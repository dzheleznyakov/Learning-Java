package zh.learn.java.ch23sorting.exercises;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import zh.learn.java.ch23sorting.listings.HeapWithComparable;

import java.util.ArrayList;
import java.util.List;

public class HeapVisualization extends Application {
    private static final Insets PADDING_5 = new Insets(5.0);
    private static final Insets PADDING_10 = new Insets(10.0);

    private Heap<Integer> heap = new HeapWithComparable<>();

    private Text usageTxt;
    private HeapPane heapPane;
    private HBox controlBox;
    private TextField insertFld;
    private Button insertBtn;
    private Button removeBtn;
    private BorderPane root;
    private Scene scene;

    @Override
    public void start(Stage stage) {
        usageTxt = getUsageText();
        heapPane = getHeapPane();
        controlBox = getControlBox();

        root = new BorderPane();
        root.setTop(usageTxt);
        root.setCenter(heapPane);
        root.setBottom(controlBox);

        root.setPadding(PADDING_10);

        scene = new Scene(root, 600.0, 400.0);
        stage.setScene(scene);
        stage.setTitle("Heap Animation");
        stage.show();

        bind();
    }

    private Text getUsageText() {
        String text = "Usage: Enter an integer key and click the Insert button to insert the key into the heap." +
                " Click the Remove the root button to remove the root from the heap";
        Text usageTxt = new Text(text);
        BorderPane.setMargin(usageTxt, PADDING_5);
        return usageTxt;
    }

    private HeapPane getHeapPane() {
        HeapPane heapPane = new HeapPane(heap);
        heapPane.setPadding(PADDING_5);
        heapPane.setStyle("-fx-border-width: 1px;" +
                "-fx-border-color: black");
        return heapPane;
    }

    private HBox getControlBox() {
        HBox insertControlBox = getInsertControlBox();
        removeBtn = getRemoveButton();
        HBox controlBox = new HBox(5.0, insertControlBox, removeBtn);
        controlBox.setPadding(PADDING_5);
        controlBox.setAlignment(Pos.CENTER);
        return controlBox;
    }

    private Button getRemoveButton() {
        return new Button("Remove the root");
    }

    private HBox getInsertControlBox() {
        Label insertLbl = new Label("Enter a key:");
        insertFld = new TextField("");
        insertFld.setPrefColumnCount(4);
        insertBtn = new Button("Insert");
        HBox box = new HBox(3.0, insertLbl, insertFld, insertBtn);
        box.setAlignment(Pos.CENTER);
        box.setPadding(PADDING_5);
        box.setStyle("-fx-border-width: 1px;" +
                "-fx-border-color: black;");
        return box;
    }

    private void bind() {
        usageTxt.wrappingWidthProperty().bind(
                scene.widthProperty()
                        .subtract(BorderPane.getMargin(usageTxt).getLeft() + BorderPane.getMargin(usageTxt).getRight())
                        .subtract(root.getPadding().getLeft() + root.getPadding().getRight()));

        insertBtn.setOnAction(event -> {
            int item;
            try {
                item = Integer.parseInt(insertFld.getText());
                heapPane.add(item);
            } catch (NumberFormatException ex) {
                log(String.format("[%s] is not a number", insertFld.getText()));
            }
        });
        insertFld.setOnAction(insertBtn.getOnAction());
        removeBtn.setOnAction(event -> heapPane.remove());
    }

    public static void main(String[] args) {
        launch(args);
    }

    private static void log(String message) {
        System.out.println(message);
    }
}

class HeapPane extends StackPane {
    private final Heap<Integer> heap;
    private Pane pane = new Pane();

    HeapPane(Heap<Integer> heap) {
        this.heap = heap;
        layoutView();
    }

    private void layoutView() {
        pane.getChildren().clear();
        if (!getChildren().contains(pane))
            getChildren().add(pane);

        if (heap.getSize() == 0) return;

        int height = (int) (Math.log(heap.getSize()) / Math.log(2)) + 1;
        List<Element> elements = new ArrayList<>(heap.getSize());
        int level = 0;
        int pos = 1;
        List<Integer> items = heap.getItems();
        for (int i = 0; i < items.size(); ++i) {
            Integer item = items.get(i);
            int parentIndex = i == 0 ? -1 : (i - 1) / 2;
            int levelSize = (int) Math.pow(2, level);
            Element parent = parentIndex >= 0 ? elements.get(parentIndex) : null;
            boolean isLeftChild = i == 2 * parentIndex + 1;

            Element element = new Element(item);
            elements.add(element);


            double centreX;
            DoubleBinding centreXBinding;
            if (parent == null) {
                centreX = pane.getWidth() / (Math.pow(2, levelSize));
//                centreXBinding = pane.widthProperty().divide(Math.pow(2, levelSize));
            }
            else {
//                int parentLevelSize = (int) Math.pow(2, level - 1);
                double hGap = pane.getWidth() / Math.pow(2, levelSize);
                double parentCentreX = parent.getLayoutX() + parent.getWidth() / 2;
                double sign = isLeftChild ? -1 : 1;
                centreX = parentCentreX + sign * hGap;
//                DoubleBinding hGapBinding = pane.widthProperty().divide(Math.pow(2, levelSize));
//                DoubleBinding parentCentreXBinding = parent.layoutXProperty().add(parent.widthProperty().divide(2));
//                centreXBinding = parentCentreXBinding.add(hGapBinding.divide(2).multiply(sign));
            }
            element.setLayoutX(centreX - element.getWidth() / 2);
//            element.layoutXProperty().bind(centreXBinding);

            double vGap = Math.min(pane.getHeight() / height, 100.0);
            double topY =  vGap * level;
            element.setLayoutY(topY);

            ++pos;
            if (pos > levelSize) {
                pos = 1;
                ++level;
            }
        }

        pane.getChildren().addAll(elements);
    }

    void add(int item) {
        heap.add(item);
        layoutView();
    }

    void remove() {
        heap.remove();
        layoutView();
    }
}

class Element extends StackPane {
    private static final double RADIUS = 16.0;

    private final int value;

    Element(int value) {
        this.value = value;
        layoutView();
    }

    private void layoutView() {
        Circle circ = new Circle(RADIUS);
        circ.setStroke(Color.BLACK);
        circ.setFill(Color.WHITE);

        Text num = new Text(String.valueOf(value));
        num.setFont(Font.font(RADIUS * 0.8));

        getChildren().addAll(circ, num);
    }
}

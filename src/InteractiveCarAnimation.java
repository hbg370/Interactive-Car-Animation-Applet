import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class InteractiveCarAnimation extends Application {
	
	public static void main(String args[]) {
		launch(args);
	}
	
	
@Override // Override the start method in the Application class
public void start(Stage primaryStage) {
	TextField tfCar1 = new TextField();
	TextField tfCar2 = new TextField();
	TextField tfCar3 = new TextField();
	TextField tfCar4 = new TextField();
	tfCar1.setPrefColumnCount(2);
	tfCar2.setPrefColumnCount(2);
	tfCar3.setPrefColumnCount(2);
	tfCar4.setPrefColumnCount(2);
	HBox hBox = new HBox(5);
	hBox.setAlignment(Pos.TOP_CENTER);
	hBox.setPadding(new Insets(10, 10, 10, 10));
	hBox.getChildren().addAll(new Label("Car 1: "), tfCar1,
	new Label("Car 2: "), tfCar2, new Label("Car 3: "), tfCar3,
	new Label("Car 4: "), tfCar4);
	
	Pane pa = new Pane();
	CarPane p1 = new CarPane();
	CarPane p2 = new CarPane();
	CarPane p3 = new CarPane();
	CarPane p4 = new CarPane();
	//CarPane spd = new CarPane();
	p1.setLayoutY(50);
	p2.setLayoutY(100);
	p3.setLayoutY(150);
	p4.setLayoutY(200);
	
		

	pa.getChildren().addAll(p1, p2, p3, p4, hBox);
	
	tfCar1.setOnKeyPressed(new EventHandler<KeyEvent>(){
		@Override
		public void handle(KeyEvent a)
		{
			if (a.getCode() == KeyCode.ENTER)
			{
				int speedInput;
				//1. grab TextField entry, 2. convert to int, 3. send to Animation method
				speedInput = Integer.parseInt(tfCar1.getText());
				p1.increaseSpeed(speedInput);

			}
		}
	});
	
	tfCar2.setOnKeyPressed(new EventHandler<KeyEvent>(){
		@Override
		public void handle(KeyEvent b)
		{
			if (b.getCode() == KeyCode.ENTER)
			{
				int speedInput2;
				//1. grab TextField entry, 2. convert to int, 3. send to Animation method
				speedInput2 = Integer.parseInt(tfCar2.getText());
				p2.increaseSpeed(speedInput2);

			}
		}
	});
	
	tfCar3.setOnKeyPressed(new EventHandler<KeyEvent>(){
		@Override
		public void handle(KeyEvent c)
		{
			if (c.getCode() == KeyCode.ENTER)
			{
				int speedInput3;
				//1. grab TextField entry, 2. convert to int, 3. send to Animation method
				speedInput3 = Integer.parseInt(tfCar3.getText());
				p3.increaseSpeed(speedInput3);

			}
		}
	});
	
	tfCar4.setOnKeyPressed(new EventHandler<KeyEvent>(){
		@Override
		public void handle(KeyEvent d)
		{
			if (d.getCode() == KeyCode.ENTER)
			{
				int speedInput4;
				//1. grab TextField entry, 2. convert to int, 3. send to Animation method
				speedInput4 = Integer.parseInt(tfCar4.getText());
				p4.increaseSpeed(speedInput4);

			}
	
		}
	});
	
	primaryStage.setScene(new Scene(pa, 350, 250));
	primaryStage.setTitle("Interactive Car Animation");
	primaryStage.show();
	//TO DO:: You complete the rest of this class
	// Need to create CarPane instances and add listeners
	
}
//Car pane is
class CarPane extends Pane {
	//These first group of fields are for drawing a carPane and cars inside the respective carPanes
	// See the constructor for putting a car together.
	private double w = 350; //width of a carPane
	private double h = 40; //height of a carPane
	private double baseX = 0;
	
	private double baseY = h;
	private Circle c1 = new Circle(baseX + 10 + 5, baseY - 10 + 5, 5);
	private Circle c2 = new Circle(baseX + 30 + 5, baseY - 10 + 5, 5);
	private Rectangle carBody = new Rectangle(baseX, baseY - 20, 50, 10);
	private Polygon carTop = new Polygon(baseX + 10, baseY - 20,
	baseX + 20, baseY - 30, baseX + 30, baseY - 30,
	baseX + 40, baseY - 20);
	private Rectangle r1 = new Rectangle(w, h);
	private Rectangle divMarker1 = new Rectangle(baseX, baseY - 25, 30, 10);
	private Rectangle divMarker2 = new Rectangle(baseX + 50, baseY - 25, 30, 10);
	private Rectangle divMarker3 = new Rectangle(baseX + 100, baseY - 25, 30, 10);
	private Rectangle divMarker4 = new Rectangle(baseX + 150, baseY - 25, 30, 10);
	private Rectangle divMarker5 = new Rectangle(baseX + 200, baseY - 25, 30, 10);
	private Rectangle divMarker6 = new Rectangle(baseX + 250, baseY - 25, 30, 10);
	private Rectangle divMarker7 = new Rectangle(baseX + 300, baseY - 25, 30, 10);
	
	Timeline timeline = new Timeline();
	
	KeyValue wheel1 = new KeyValue(c1.translateXProperty(), 350);
	KeyFrame wheel1x = new KeyFrame(Duration.seconds(10), wheel1);
	
	KeyValue wheel2 = new KeyValue(c2.translateXProperty(), 350);
	KeyFrame wheel2x = new KeyFrame(Duration.seconds(10), wheel2);
	
	KeyValue Cbody = new KeyValue(carBody.translateXProperty(), 350);
	KeyFrame Cbodyx = new KeyFrame(Duration.seconds(10), Cbody);
	
	KeyValue Ctop = new KeyValue(carTop.translateXProperty(), 350);
	KeyFrame Ctopx = new KeyFrame(Duration.seconds(10), Ctop);
	//...
	//Now, the constructor of a car:
	public CarPane() {
		
		this.setStyle("-fx-border-color: black");
		//car colors
		carBody.setFill(Color.GREEN);
		carTop.setFill(Color.RED);
		c1.setFill(Color.BLACK);
		c2.setFill(Color.BLACK);
		//road colors
		r1.setFill(Color.DIMGRAY);
		divMarker1.setFill(Color.YELLOW);
		divMarker2.setFill(Color.YELLOW);
		divMarker3.setFill(Color.YELLOW);
		divMarker4.setFill(Color.YELLOW);
		divMarker5.setFill(Color.YELLOW);
		divMarker6.setFill(Color.YELLOW);
		divMarker7.setFill(Color.YELLOW);


		this.getChildren().addAll(r1, divMarker1, divMarker2, divMarker3, divMarker4, divMarker5,
		divMarker6, divMarker7, c1, c2, carBody, carTop);
		
		
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.getKeyFrames().add(wheel1x);
		timeline.getKeyFrames().add(wheel2x);
		timeline.getKeyFrames().add(Cbodyx);
		timeline.getKeyFrames().add(Ctopx);
		
	// Add more CarPane code
	// ...
	}
	
	public void increaseSpeed(int speed)
	{
		timeline.setRate(speed);
		timeline.play();		
	}
	
}

}
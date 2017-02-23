package uniandes.conceptosAvanzados.programm1;

public class Controller {

	private Model model;

	public Controller() {
		super();
		this.model = new Model();
	}

	public void start() {
		model.readFile();
		model.calculateMean();
		model.calculateStdDev();

	}

	public void show() {
		System.out.println(model.getMean());
		System.out.println(model.getStdDev());
	}

}

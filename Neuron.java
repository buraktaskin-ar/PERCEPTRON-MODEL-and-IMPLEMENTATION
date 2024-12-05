package proje1;

import java.util.Random;

public class Neuron {

	private double learningRate;
	private double[] weights;
	public double [] [] testData;

	// Getters and setters.
	public double[] getWeights() {
		return weights;
	}

	public void setWeights(double[] weights) {
		this.weights = weights;
	}

	public double getLearningRate() {
		return learningRate;
	}

	public void setLearningRate(double learningRate) {
		this.learningRate = learningRate;
	}

	public double[][] getTestData() {
		return testData;
	}

	public void setTestData(double[][] testData) {
		this.testData = testData;
	}

	// Values of weights are initialized randomly not manuel.
	// Therefore, it is not included as a parameter in the constructor.
	public Neuron(double learningRate, double[][] testData) {
		this.testData = testData;
		this.learningRate = learningRate;
		weights = new double[2];
		Random rand = new Random();

		// initialize the weights randomly
		for (int i = 0; i < 2; i++) {
			weights[i] = rand.nextDouble();
		}
	}

	// Calculate output by using weights and inputs list.
	private double calculateOutput(double[] inputs) {

		double sum = 0;
		for (int i = 0; i < inputs.length; i++) {
			sum += inputs[i] * weights[i];
		}

		return sum;
	}

	// Train process.
	private void train(double[] inputs, double target) {

		double output = calculateOutput(inputs);
		double result = target - output;
		for (int i = 0; i < weights.length; i++) {
			double weightUpdate = learningRate * result * inputs[i];
			weights[i] += weightUpdate;
		}
	}

	// Trains the neuron depending on the number of epochs.
	public void epoch(int numEpochs){
		for (int epoch = 0; epoch < numEpochs; epoch++) {
			for (double[] data : testData) {
				double inputs[] = {(double) data[0] / 10, (double) data[1] / 15 };
				double target = (double) data[2] / 100;
				train(inputs, target);
			}
		}
		System.out.println();

	}
	// Calculate mse value.
	public double calculateMse(){
		double mse = 0;
		for (double[] data : testData) {
			double inputs[] = {(double) data[0] / 10, (double) data[1] / 15 };
			double target = (double) data[2] / 100;
			double prediction = calculateOutput(inputs);
			mse += Math.pow(target - prediction, 2);
		}
		mse /= testData.length;

		return mse;
	}

	public void  showOutputs(){
		System.out.println("  Input Values   -   Target Value    -    Predicted Value");
		for (double[] data : testData) {
			double inputs[] = {(double) data[0] / 10, (double) data[1] / 15 };
			double target = (double) data[2] / 100;
			double prediction = calculateOutput(inputs);
			System.out.printf(" %4.2f  ", inputs[0] );
			System.out.printf(" %4.2f  ", inputs[1]);
			System.out.printf("         %4.2f  ", target);
			System.out.printf("               %4.2f  ", prediction);
			System.out.println();
		}
	}


}
	/// The end of the neuron class.


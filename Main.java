package proje1;

public class Main {
	public static void main(String[] args) {

		double[][] testData = {
			{7.6, 11, 77},
			{8, 10, 70},
			{6.6, 8, 55},
			{8.4, 10, 78},
			{8.8, 12, 95},
			{7.2, 10, 67},
			{8.1, 11, 80},
			{9.5, 9, 87},
			{7.3, 9, 60},
			{8.9, 11, 88},
			{7.5, 11, 72},
			{7.6, 9, 58},
			{7.9, 10, 70},
			{8, 10, 76},
			{7.2, 9, 58},
			{8.8, 10, 81},
			{7.6, 11, 74},
			{7.5, 10, 67},
			{9, 10, 82},
			{7.7, 9, 62},
			{8.1, 11, 82}

		};
		// New input value
		double testData2[][] = {
			{9.2, 9.3, 83},
			{7.4, 9.1, 66},
			{8.1, 12, 88},
			{7.6, 8, 62},
			{7.3, 9, 57},
			{8.1, 10, 71}
		};

		Neuron n1 = new Neuron(0.05,testData);
		n1.epoch(10);
		System.out.println("Mse:" + n1.calculateMse());;
		n1.showOutputs();

		// The predictions are calculated  with updated weights of  first neuron .

		System.out.println("   New inputs: ");
		n1.setTestData(testData2);
		n1.showOutputs();

		System.out.println();
		int[] epoklar = {10, 50, 100};
		double[] lambdalar = {0.01, 0.025, 0.05};
		double[][] mseSonuclari = new double[epoklar.length][lambdalar.length];

		// for  3*3 table using the lists above.
		for(int count = 0; count < 3; count++ ){
			for (int i = 0; i < epoklar.length; i++) {
				for (int j = 0; j < lambdalar.length; j++) {
					Neuron n2 = new Neuron(lambdalar[j],testData);
					int epok = epoklar[i];
					double lambda = lambdalar[j];
					n2.epoch(epoklar[i]);
					mseSonuclari[i][j] = n2.calculateMse();
				}
			}

			for (int i = 0; i < epoklar.length; i++) {
				for (int j = 0; j < lambdalar.length; j++) {
					System.out.println("Epok: " + epoklar[i] + ", λ: "
						+ lambdalar[j] + " - MSE: " + mseSonuclari[i][j]);
				}
			}
		}   // end of the for loop.
	}
}



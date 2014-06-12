package me.cristiangomez.boladecristal;

import java.util.Random;

public class CristalBall {
	public String getAnswer() {
		String answer;
		String[] answersArray = { "Cierto es", "Definitivamente",
				"Todo apunta a que SI", "Las estrellas no estan alineadas",
				"Mi respuesta es no", "Es dudoso", "Mejor no decirte",
				"Concentrate y pregunta de nuevo",
				"No puedo responder a eso ahora", "Es dificil de decir" };

		// Randomly select one of three answers: Yes, No, or Maybe
		Random randomGenerator = new Random();
		int randomNumber = randomGenerator.nextInt(answersArray.length);
		answer = answersArray[randomNumber];
		return answer;
	}
}

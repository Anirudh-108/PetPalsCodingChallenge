package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.exception.InsufficientFundException;
import com.exception.InvalidPetAgeException;
import com.model.CashDonation;
import com.model.Cat;
import com.model.Dog;
import com.model.Donation;
import com.model.ItemDonation;
import com.model.Participant;
import com.model.Pet;
import com.service.CashDonationService;
import com.service.CatService;
import com.service.DogService;
import com.service.DonationService;
import com.service.ItemDonationService;
import com.service.ParticipantService;
import com.service.PetService;

public class PetPalsController {
	public static void main(String[] args) {
		PetService petService = new PetService();
		DogService dogService = new DogService();
		CatService catService = new CatService();
		ParticipantService participantService = new ParticipantService();
		DonationService donationService = new DonationService();
		CashDonationService cashDonationService = new CashDonationService();
		ItemDonationService itemDonationService = new ItemDonationService();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println();
			System.out.println("-------------Welcome to Pet Pals-------------");
			System.out.println();
			System.out.println("Press 1. Add Pet");
			System.out.println("Press 2. Remove Pet");
			System.out.println("Press 3. Show All Available Pets");
			System.out.println("Press 4. Make Donation");
			System.out.println("Press 5. Adoption Event");
			System.out.println("Press 0. To Exit");
			System.out.print("Choose an option: ");
			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Exiting from Pet Pals...");
				System.out.println("Thank you for using Pet Pals application");
				break;
			}
			switch (input) {
			case 1:
				System.out.println();
				System.out.println("-------------Add Pet-------------");
				Random random = new Random();
				int randomNumber = random.nextInt();
				int petId = randomNumber < 0 ? randomNumber * -1 : randomNumber;
				sc.nextLine();
				System.out.print("Enter pet name : ");
				String petName = sc.nextLine().trim();
				System.out.print("Enter pet age : ");
				int petAge = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter pet type (Dog/Cat): ");
				String petType = sc.nextLine().trim();
				int isAvailable = 1;
				Pet pet = new Pet(petId, petName, petAge, petType, isAvailable);

				random = new Random();
				randomNumber = random.nextInt();
				int id = randomNumber < 0 ? randomNumber * -1 : randomNumber;

				try {
					if (petType.equalsIgnoreCase("dog")) {
						System.out.print("Enter dog breed : ");
						String dogBreed = sc.nextLine().trim();
						Dog dog = new Dog(id, dogBreed);
						int petStatus = petService.save(pet);
						int dogStatus = dogService.save(dog);
						if (petStatus == 1 && dogStatus == 1)
							System.out.println("Pet added successfully!!!");
						else
							System.out.println("Pet addition failed...");
					} else if (petType.equalsIgnoreCase("cat")) {
						System.out.print("Enter cat color : ");
						String catColor = sc.nextLine().trim();
						Cat cat = new Cat(id, catColor);
						int petStatus = petService.save(pet);
						int catStatus = catService.save(cat);
						if (petStatus == 1 && catStatus == 1)
							System.out.println("Pet added successfully!!!");
						else
							System.out.println("Pet addition failed...");
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} catch (InvalidPetAgeException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 2:
				System.out.println();
				try {
					List<Pet> list = petService.getAllPets();
					for (Pet a : list)
						System.out.println(a);
					System.out.print("Choose pet id from above to remove : ");
					petId = sc.nextInt();
					int status = petService.removePetById(petId);// Soft delete
					if (status == 1)
						System.out.println("Pet removed successfully!!!");
					else
						System.out.println("Pet removal failed!!!");
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 3:
				System.out.println();
				System.out.println("-------------All Available Pets-------------");
				try {
					List<Pet> list = petService.getAllAvailablePets();
					for (Pet a : list)
						System.out.println(a);
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 4:
				System.out.println();
				System.out.println("-------------Make Donation-------------");
				random = new Random();
				randomNumber = random.nextInt();
				int donationId = randomNumber < 0 ? randomNumber * -1 : randomNumber;
				try {
					sc.nextLine();
					List<Pet> list = petService.getAllPets();
					for (Pet a : list)
						System.out.println(a);
					System.out.print("Choose pet id from above to donate : ");
					petId = sc.nextInt();
					sc.nextLine();
					System.out.print("Enter your name : ");
					String donorName = sc.nextLine().trim();
					System.out.print("Enter donation type (cash/item): ");
					String donationType = sc.nextLine();
					Donation donation = new Donation(donationId, donorName, petId);

					random = new Random();
					randomNumber = random.nextInt();
					id = randomNumber < 0 ? randomNumber * -1 : randomNumber;
					if (donationType.equalsIgnoreCase("cash")) {
						System.out.print("Enter donation amount : ");
						double donationAmount = sc.nextDouble();
						sc.nextLine();
						System.out.print("Enter today's date : ");
						String donationDate = sc.nextLine();
						CashDonation cashDonation = new CashDonation(id, donationAmount, donationDate);
						int donationStatus = donationService.recordDonation(donation);
						int cashDonationStatus = cashDonationService.recordDonation(cashDonation, donationId);
						if (donationStatus == 1 && cashDonationStatus == 1)
							System.out.println("Amount donated successfully!!!");
						else
							System.out.println("Amount donation failed...");
					} else if (donationType.equalsIgnoreCase("item")) {
						System.out.print("Enter donation item name : ");
						String donationItem = sc.nextLine();
						System.out.print("Enter today's date : ");
						String donationDate = sc.nextLine();
						ItemDonation itemDonation = new ItemDonation(id, donationItem, donationDate);
						int donationStatus = donationService.recordDonation(donation);
						int itemDonationStatus = itemDonationService.recordDonation(itemDonation, donationId);
						if (donationStatus == 1 && itemDonationStatus == 1)
							System.out.println("Item donated successfully!!!");
						else
							System.out.println("Item donation failed...");
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} catch (InsufficientFundException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 5:
				System.out.println();
				System.out.println("-------------Adoption Event-------------");
				System.out.println();
				System.out.println("Press 1. Adopt Pet");
				System.out.println("Press 2. Register Participant");
				System.out.println("Press 3. Show All Participants");
				System.out.println("Press 4. Host Event");
				System.out.println("Press 0. To Back");
				System.out.print("Choose an option: ");
				input = sc.nextInt();
				if (input == 0) {
					PetPalsController.main(args);
					break;
				}
				switch (input) {
				case 1:
					break;

				case 2:
					System.out.println();
					System.out.println("-------------Register Participant-------------");
					random = new Random();
					randomNumber = random.nextInt();
					int participantId = randomNumber < 0 ? randomNumber * -1 : randomNumber;
					sc.nextLine();
					System.out.print("Enter participant name : ");
					String participantName = sc.nextLine().trim();
					System.out.print("Enter participant type : ");
					String participantType = sc.nextLine().trim();
					Participant participant = new Participant(participantId, participantName, participantType);
					try {
						int participantStatus = participantService.addParticipant(participant);
						if (participantStatus == 1)
							System.out.println("Participant registered successfully!!!");
						else
							System.out.println("Participant registration failed...");
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
					break;

				case 3:
					System.out.println();
					System.out.println("-------------All Participants-------------");
					try {
						List<Participant> list = participantService.getAllParticipants();
						for (Participant a : list)
							System.out.println(a);
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
					break;

//				case 4:
//					System.out.println();
//					System.out.println("-------------Host Event-------------");
//					random = new Random();
//					randomNumber = random.nextInt();
//					int eventId = randomNumber < 0 ? randomNumber * -1 : randomNumber;
//					sc.nextLine();
//					try {
//						System.out.print("Enter event name : ");
//						String eventName = sc.nextLine().trim();
//						System.out.print("Enter event date : ");
//						String eventDate = sc.nextLine().trim();
//						System.out.print("Enter event address : ");
//						String eventAddress = sc.nextLine().trim();
//						List<Participant> list = participantService.getAllParticipants();
//						for (Participant a : list)
//							System.out.println(a);
//						participantId = sc.nextInt();
//						System.out.print("Choose Participant id from above : ");
//						List<Pet> list1 = petService.getAllPets();
//						for (Pet a : list1)
//							System.out.println(a);
//						System.out.print("Choose pet id from above : ");
//						petId = sc.nextInt();
//						try {
//							int participantStatus = participantService.addParticipant(participant);
//							if (participantStatus == 1)
//								System.out.println("Participant registered successfully!!!");
//							else
//								System.out.println("Participant registration failed...");
//						} catch (SQLException e) {
//							System.out.println(e.getMessage());
//						}
//					} catch (SQLException e) {
//						System.out.println(e.getMessage());
//					}
//					break;
				}

				break;

			default:
				System.out.println();
				System.out.println("Please select a valid option");
			}
		}
		sc.close();
	}
}

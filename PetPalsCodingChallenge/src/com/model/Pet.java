package com.model;

public class Pet {
	private int petId;
	private String name;
	private int age;
	private String type;
	private int isAvailable;

	public Pet() {
		super();
	}

	public Pet(int petId, String name, int age, String type, int isAvailable) {
		super();
		this.petId = petId;
		this.name = name;
		this.age = age;
		this.type = type;
		this.isAvailable = isAvailable;
	}

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(int isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return "Pet [petId=" + petId + ", name=" + name + ", age=" + age + ", type=" + type + ", isAvailable="
				+ isAvailable + "]";
	}
}

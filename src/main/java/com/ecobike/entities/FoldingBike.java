package com.ecobike.entities;

public class FoldingBike extends Bike {

    private int wheelsSize;

    private int gears;

    public FoldingBike() {
        super();
    }

    public FoldingBike(String brand, int wheelsSize, int gears, int weight, boolean lights, String color, int price) {
        super(brand, weight, lights, color, price);
        this.wheelsSize = wheelsSize;
        this.gears = gears;
    }

    public int getWheelsSize() {
        return wheelsSize;
    }

    public void setWheelsSize(int wheelsSize) {
        this.wheelsSize = wheelsSize;
    }

    public int getGears() {
        return gears;
    }

    public void setGears(int gears) {
        this.gears = gears;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FoldingBike)) return false;
        if (!super.equals(o)) return false;

        FoldingBike that = (FoldingBike) o;

        if (wheelsSize != that.wheelsSize) return false;
        return gears == that.gears;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + wheelsSize;
        result = 31 * result + gears;
        return result;
    }

    @Override
    public String toString() {
        String hasLights = super.isLights() ? "" : "no";
        return "E-BIKE " + super.getBrand() + " with " + this.gears + " gear(s) and " + hasLights +
                " head/tail light\n" + "Price:" + super.getPrice() ;
    }

    @Override
    public void createBikeInstance() {
            super.createBikeInstance();
        System.out.println("Enter wheels size");
            this.setWheelsSize(Integer.parseInt(scanner.nextLine()));
        System.out.println("Enter number of gears");
            this.setGears(Integer.parseInt(scanner.nextLine()));
    }

    @Override
    public String prepareToWrite() {
        return "FOLDING BIKE " + super.getBrand() + ";" + wheelsSize + ";" + gears + ";" + super.getWeight() + ";" +
                super.isLights() + ";" + super.getColor() + ";" + super.getPrice();
    }
}

package com.ecobike.entities;

public class ElectroBike extends Bike {

    private int maxSpeed;

    private int batteryCapacity;

    public ElectroBike() {
        super();
    }

    public ElectroBike(String brand, int maxSpeed, int weight, boolean lights, int batteryCapacity, String color, int price) {
        super(brand, weight, lights, color, price);
        this.maxSpeed = maxSpeed;
        this.batteryCapacity = batteryCapacity;
    }

    public int getMaxSpeed() { return maxSpeed; }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getBatteryCapacity() { return batteryCapacity; }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ElectroBike)) return false;
        if (!super.equals(o)) return false;

        ElectroBike that = (ElectroBike) o;

        if (maxSpeed != that.maxSpeed) return false;
        return batteryCapacity == that.batteryCapacity;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + maxSpeed;
        result = 31 * result + batteryCapacity;
        return result;
    }

    @Override
    public String toString() {
        String hasLights = super.isLights() ? "" : "no";
        return "E-BIKE " + super.getBrand() + " with " + this.batteryCapacity + " mAh battery and " + hasLights +
                " head/tail light\n" + "Price:" + super.getPrice() ;
    }

    @Override
    public void createBikeInstance() {
            super.createBikeInstance();
        System.out.println("Enter max speed");
            this.setMaxSpeed(Integer.parseInt(scanner.nextLine()));
        System.out.println("Enter battery capacity");
            this.setBatteryCapacity(Integer.parseInt(scanner.nextLine()));
    }

    @Override
    public String prepareToWrite() {
        return "E-BIKE " + super.getBrand() + ";" + maxSpeed + ";" + super.getWeight() + ";" + super.isLights() +
                ";" + batteryCapacity + ";" + super.getColor() + ";" + super.getPrice();
    }
}

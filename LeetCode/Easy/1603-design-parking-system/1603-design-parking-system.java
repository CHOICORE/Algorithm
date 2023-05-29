class ParkingSystem {
    int small;
    int medium;
    int big;

    public ParkingSystem(int big, int medium, int small) {
        this.small = small;
        this.medium = medium;
        this.big = big;
    }

    public boolean addCar(int carType) {
        if (carType == 3) {
            small--;
            return small >= 0;
        } else if (carType == 2) {
            medium--;
            return medium >= 0;
        } else {
            big--;
            return big >= 0;
        }
    }
}
/**
* Your ParkingSystem object will be instantiated and called as such:
* ParkingSystem obj = new ParkingSystem(big, medium, small);
* boolean param_1 = obj.addCar(carType);
*/
package it.unibo.oop.lab.exception1;

public class NotEnoughBatteryException extends IllegalStateException {
	
	private static final long serialVersionUID = 5322262957171100504L;
    private final int x;
    private final int y;
	
    public NotEnoughBatteryException(final int initX, final int initY) {
        super();
        this.x = initX;
        this.y = initY;
    }
    
	@Override
    public String toString() {
        return "Can not move to position(" + this.x + "," + this.y + "). Not enough battery.";
    }

    @Override
    public String getMessage() {
        return this.toString();
    }
}

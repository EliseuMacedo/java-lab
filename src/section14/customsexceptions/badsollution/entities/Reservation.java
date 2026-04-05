package section14.customsexceptions.badsollution.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    // para que não seja instanciado um novo sdf para cada new Reservation, eu vou precisar só de um
    private static SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    public Reservation() {
    }

    public Reservation(Date checkIn, Date checkOut, Integer roomNumber) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Long duration() {
        final long duration = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(duration, TimeUnit.MILLISECONDS);
    }

    public String updateDates(Date checkIn, Date checkOut) {

        // Date now = new Date(); use to validate now
        if (checkIn.before(getCheckIn()) || checkOut.before(getCheckOut())) {
            return "Error in reservation: Reservation dates for update must be future dates";
        }
        if (checkIn.after(checkOut)) {
            return "Error in reservation: Check-out date must be after check-in date";
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;

        return null;
    }

    @Override
    public String toString() {
        return "Reservation: Room " +
                roomNumber +
                ", check-in: " +
                SDF.format(checkIn) +
                ", check-out: " +
                SDF.format(checkOut) +
                ", " +
                duration() +
                " nights";

    }
}

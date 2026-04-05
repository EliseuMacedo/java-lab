package section14.exception.customsExceptions.goodSolution.entities;

import section14.exception.customsExceptions.goodSolution.exceptions.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    // para que não seja instanciado um novo sdf para cada new Reservation, eu vou precisar só de um
    private final static  SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    public Reservation() {
    }

    public Reservation(Date checkIn, Date checkOut, Integer roomNumber) throws DomainException {
        if (checkIn.after(checkOut)) {
            throw new DomainException("Check-out date must be after check-in date");
        }
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

    public void updateDates(Date checkIn, Date checkOut) throws DomainException {

        // Date now = new Date(); use to validate now
        if (checkIn.before(getCheckIn()) || checkOut.before(getCheckOut())) {
           throw new DomainException("Reservation dates for update must be future dates");
        }
        if (checkIn.after(checkOut)) {
            throw new DomainException("Check-out date must be after check-in date");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
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

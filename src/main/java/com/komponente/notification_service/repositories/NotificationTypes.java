package com.komponente.notification_service.repositories;

/*
String fs;
fs = String.format("The value of the float " +
                   "variable is %f, while " +
                   "the value of the " +
                   "integer variable is %d, " +
                   " and the string is %s",
                   floatVar, intVar, stringVar);
 */
public class NotificationTypes {
    
    public static final String ACCOUNT_ACTIVATION = "Account Activation";
    public static final String PASSWORD_RESET = "Password Reset";
    public static final String RESERVATION_CONFIRMED = "Reservation Confirmed";
    public static final String RESERVATION_CANCELLED = "Reservation Cancelled";
    public static final String RESERVATION_REMINDER = "Reservation Reminder";
    public static final String MANAGER_RESERVATION_CONFIRMED = "Manager Reservation Confirmed";
    public static final String MANAGER_RESERVATION_CANCELLED = "Manager Reservation Cancelled";

    public static String getMail(String type, String username, String companyName){
        return switch (type) {
            case ACCOUNT_ACTIVATION -> "Successfully registered, username: " + username;
            case PASSWORD_RESET -> "Successfully changed your password";
            case RESERVATION_CONFIRMED -> "Successfully made a reservation: " + companyName;
            case RESERVATION_CANCELLED -> "Successfully cancelled your reservation: " + companyName;
            case RESERVATION_REMINDER -> "Reminder: Your reservation: " + companyName + " is in three days";
            case MANAGER_RESERVATION_CANCELLED -> "User: " + username + " has cancelled a reservation at your hotel";
            case MANAGER_RESERVATION_CONFIRMED -> "User: " + username + " has made a reservation at your hotel";
            default -> "";
        };
    }

}

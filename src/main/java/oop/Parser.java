package oop;

import java.time.LocalDate;
import java.time.LocalTime;

public class Parser {
    public static String parseToDO(String command){
        final int commandLength=5;
        return command.substring(commandLength);
    }

    public static String[] parseDeadline(String command){
        final int commandLength=9;
        String[] commandContain = command.substring(commandLength).split("/");
        return commandContain;
    }

    public static String[] parseEvent(String command){
        final int commandLength=6;
        String[] commandContain = command.substring(commandLength).split("/");
        return commandContain;
    }

    /**
     *Accept a deadline command and then get the date of the deadline
     *
     * @param command input command
     * @return the date of the deadline
     * @throws DukeException if date is missing
     */
    public static LocalDate parseDeadlineDate(String command) throws DukeException {
        String[] commandContain= parseDeadline(command);
        String dateInformation=commandContain[1];
        String[] dateContain= dateInformation.split(" ");
        if(dateContain.length<2){
            throw new DukeException("OOPS!!! please ensure both date and time are written");
        }
        return LocalDate.parse(dateContain[1]);
    }

    /**
     * Accept a Event command and then get the date of the event
     *
     * @param command input command
     * @return the date of the event
     * @throws DukeException if date is missing
     */
    public static LocalDate parseEventDate(String command) throws DukeException {
        String[] commandContain= parseEvent(command);
        String dateInformation=commandContain[1];
        String[] dateContain= dateInformation.split(" ");
        if(dateContain.length<2){
            throw new DukeException("OOPS!!! please ensure both date and time are written");
        }
        return LocalDate.parse(dateContain[1]);
    }

    /**
     * Accept a Deadline command and then get the time of the deadline
     *
     * @param command input command
     * @return the time of the deadline
     * @throws DukeException if time is missing
     */
    public static LocalTime parseDeadlineTime(String command) throws DukeException{
        String[] commandContain= parseDeadline(command);
        String dateInformation=commandContain[1];
        String[] dateContain= dateInformation.split(" ");
        if(dateContain.length<3){
            throw new DukeException("OOPS!!! please ensure both date and time are written");
        }
        return LocalTime.parse(dateContain[2]);

    }

    /**
     * Accept a Event command and then get the time of the event
     *
     * @param command input command
     * @return the start time and the end time
     * @throws DukeException if the time is missing. if start time or end time is missing
     */
    public static String[] parseEventTime(String command) throws DukeException{
        String[] commandContain= parseEvent(command);
        String dateInformation=commandContain[1];
        String[] dateContain= dateInformation.split(" ");
        if(dateContain.length<3){
            throw new DukeException("OOPS!!! please ensure both date and time are written");
        }
        String[] timeContain= dateContain[2].split("-");
        if(timeContain.length!=2){
            throw new DukeException("OOPS!!! please ensure that both start time and end time of the event have been written");
        }
        return timeContain;
    }
}

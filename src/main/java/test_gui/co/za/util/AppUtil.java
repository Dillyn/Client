package test_gui.co.za.util;

public class AppUtil {

    private final String URI = "http://localhost:8080/";
    private final String invalidLoginInput = "INVALID INPUT";
    private final String recordsUpdated = "RECORD SUCCESSFULLY UPDATED";
    private final String recordsNotUpdated = "RECORD NOT UPDATED";
    private final String recordsAdded = "RECORD SUCCESSFULLY ADDED";
    private final String recordsNotAdded = "SORRY! RECORD COULD NOT BE ADDED";
    private final String recordsFilled = "PLEASE FILL IN ALL FIELDS";
    private final String noRowSelected = "NO ROW SELECTED";
    private final String noBlankFields = "NO BLANK FIELDS ALLOWED";
    private final String deleteRecord = "RECORD SUCCESSFULLY DELETED";
    private final String notExistRecord = "RECORD DOES NOT EXIST";


    public String getUri() {
        return URI;
    }

    public String getInvalidLoginInput() {
        return invalidLoginInput;
    }

    public String getNotExistRecord() {
        return notExistRecord;
    }

    public String getDeleteRecord() {
        return deleteRecord;
    }

    public String getRecordsUpdated() {
        return recordsUpdated;
    }

    public String getRecordsNotUpdated() {
        return recordsNotUpdated;
    }

    public String getRecordsAdded() {
        return recordsAdded;
    }

    public String getRecordsNotAdded() {
        return recordsNotAdded;
    }

    public String getRecordsFilled() {
        return recordsFilled;
    }

    public String getNoRowSelected() {
        return noRowSelected;
    }

    public String getNoBlankFields() {
        return noBlankFields;
    }

    public static boolean isStringOnlyAlphabet(String str)
    {
        return ((str != null)
                && (!str.equals(""))
                && (str.matches("^[a-zA-Z]*$")));
    }
}

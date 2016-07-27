package Constants;

import java.util.logging.Logger;
/**
 *
 * @author RAVITEJA
 */
public final class StudyConstants {
	public static final Logger LOG = Logger.getLogger("Constants");

	private StudyConstants() {
		new StudyConstants();
	}
	public static final String ADD_STUDY = "INSERT INTO Study "
				+ "(studyID, studyname, description, username, datecreated, imageurl, reqparticipants, actparticipants, sstatus) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        public static final String ADD_QUESTION = "INSERT INTO Question "
				+ "(StudyID, QuestionID, Question, AnswerType, Option1, Option2, Option3, Option4, Option5) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
         public static final String ADD_ANSWER = "INSERT INTO Answer " + "(StudyID, questionId, Username, choice, Datesubmitted)"
				+ "VALUES (?, ?, ?, ?, ?)";
	public static final String GET_STUDIES = "SELECT * from Study";
	public static final String GET_STUDY = "SELECT * from Study WHERE studyid = ?";
	public static final String GET_STUDY2 = "SELECT * from Study WHERE studyid = ? and username =?";
        public static final String GET_STUDY3 = "SELECT * from Study where username=?";
        public static final String GET_STUDY4 = "SELECT * from Study where sstatus=?";
	public static final String GET_QUESTION = "SELECT * from Question where studyid=?";
	public static final String DELETE_STUDY = "DELETE FROM Study " + "WHERE StudyID = ?";
        public static final String DELETE_QUESTION = "DELETE FROM Question " + "WHERE StudyID = ?";
        public static final String UPDATE_STUDY = "UPDATE Study SET " + "StudyID = ?, " + "StudyName = ?, " + "Description = ?, "
				+ "Username = ?, " + "DateCreated = ?, " + "ImageURL = ?, " + "ReqParticipants = ?, "
				+ "ActParticipants = ?, " + "SStatus = ? " + "WHERE StudyID = ?";
        public static final String UPDATE_QUESTION = "UPDATE Question SET " + "StudyID = ?, " + "QuestionID = ?, " + "Question = ?, "
				+ "AnswerType = ?, " + "Option1 = ?, " + "Option2 = ?, " + "Option3 = ?, " + "Option4 = ?, "
				+ "Option5 = ? " + "WHERE StudyID = ?";
        public static final String UPDATE_STUDY2 = "UPDATE Study SET " + "SStatus = ? " + "WHERE StudyID = ? and username=?";
        public static final String UPDATE_STUDY3 = "UPDATE Study SET " + "ActParticipants = ? " + "WHERE StudyID = ? ";
        public static final String COUNT_STUDY = "SELECT count(*) from Study WHERE studyid = ?";
        public static final String GET_REPORT =  "SELECT * from Reported";
        public static final String GET_REPORT2 =  "SELECT * from Reported where username=?";
        public static final String GET_REPORT3 =  "SELECT * from Reported where studyid=?";
        public static final String GET_REPORT4 =  "SELECT * from Reported where studyid=? and username=?";
        public static final String ADD_REPORT = "INSERT INTO Reported "
	                + "(QuestionID, StudyID, Date, Question, Username, NumParticipants, Status) "
	                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        public static final String UPDATE_REPORT = "UPDATE Reported SET "
	                + "Status = ? "
	                + "WHERE StudyID = ? and username=?";
        public static final String GET_ANSWER = "SELECT * from Answer where username=?";
        public static final String GET_ANSWER2 = "SELECT * from Answer where studyid=?";
        public static final String INVALID_USER = "Invalid User";
        public static final String EMAIL_EXISTS = "EMAIL ALREADY EXISTS...!!";
        public static final String PASSWORDS_DONOT_MATCH = "PASSWORDS DO NOT MATCH....!!";
	
}

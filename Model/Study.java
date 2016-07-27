package Model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Study implements Serializable {

	private String studyName;
	private String studyCode;
	private Timestamp dateCreated;
	private String email;
	private String question;
	private int requestedParticipants;
	private int numOfParticipants;
	private String description;
	private String status;
	private String answerType;
	private List answers;
	private String imageURL;

	public Study(String studyName, String email, String question, int requestedParticipants, int numOfParticipants,
			String description, List answers, String studyCode, String status) {
		super();
		this.studyName = studyName;
		this.email = email;
		this.question = question;
		this.requestedParticipants = requestedParticipants;
		this.numOfParticipants = numOfParticipants;
		this.description = description;
		this.answers = answers;
		this.studyCode = studyCode;
		this.status = status;
	}

	public String getStudyName() {
		return studyName;
	}

	public void setStudyName(String studyName) {
		this.studyName = studyName;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getStudyCode() {
		return studyCode;
	}

	public void setStudyCode(String studyCode) {
		this.studyCode = studyCode;
	}

	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getRequestedParticipants() {
		return requestedParticipants;
	}

	public void setRequestedParticipants(int requestedParticipants) {
		this.requestedParticipants = requestedParticipants;
	}

	public int getNumOfParticipants() {
		return numOfParticipants;
	}

	public void setNumOfParticipants(int numOfParticipants) {
		this.numOfParticipants = numOfParticipants;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAnswerType() {
		return answerType;
	}

	public void setAnswerType(String answerType) {
		this.answerType = answerType;
	}

	public List getAnswers() {
		return answers;
	}

	public void setAnswers(List answers) {
		this.answers = answers;
	}

	public Study(String studyName, String studyCode, Timestamp dateCreated, String email, String question,
			int requestedParticipants, int numOfParticipants, String description, String status, String answerType,
			List answers) {
		super();
		this.studyName = studyName;
		this.studyCode = studyCode;
		this.dateCreated = dateCreated;
		this.email = email;
		this.question = question;
		this.requestedParticipants = requestedParticipants;
		this.numOfParticipants = numOfParticipants;
		this.description = description;
		this.status = status;
		this.answerType = answerType;
		this.answers = answers;
	}

	public Study() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Study [studyName=" + studyName + ", studyCode=" + studyCode + ", dateCreated=" + dateCreated
				+ ", email=" + email + ", question=" + question + ", requestedParticipants=" + requestedParticipants
				+ ", numOfParticipants=" + numOfParticipants + ", description=" + description + ", status=" + status
				+ ", answerType=" + answerType + ", answers=" + answers + "]";
	}

	public String getImageURL() {
		if (this.getStudyCode().startsWith("XY")) {
			return "images/image1.jpg";
		}
		if (this.getStudyCode().startsWith("X")) {
			return "images/image2.jpg";
		}
		return "images/image3.jpg";
	}

	public float getAverage(ArrayList<Integer> answer)
    {
        int temp=0;
        for(int num: answer)
        {
            temp=temp+num;
        }
        temp=temp/answer.size();
        return temp;
    }
    public int getMinimum(ArrayList<Integer> answer)
    {
        int min=0;
        for(int num: answer)
        {
            if(min<num)
            {
                min=num;
            }
        }
        return min;
    }
    public int getMaximum(ArrayList<Integer> answer)
    {
        int max=0;
        for(int num: answer)
        {
            if(max<num)
            {
                max=num;
            }
        }
        return max;
    }
    public double getSD(ArrayList<Integer> answer)
    {
        double powerSum1 = 0;
        double powerSum2 = 0;
        double stdev = 0;
        int i=0;
        for(int num: answer)
        {
            powerSum1 += num;
            powerSum2 += Math.pow(num, 2);
            stdev = Math.sqrt(i*powerSum2 - Math.pow(powerSum1, 2))/i;
            i++;
        }
        return stdev;
    }

}
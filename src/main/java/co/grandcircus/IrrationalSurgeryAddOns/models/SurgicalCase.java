package co.grandcircus.IrrationalSurgeryAddOns.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("surgeryDepot")
public class SurgicalCase {

	// refactor this to have a patient database it pulls from as well and have it
	// linked via the surgery encounter

	@Id
	private String id;
	private String surgeon;
	private String name;
	private String dateOfBirth;
	// initially had a String pt status but need different variables too boring
	private Boolean isInpatient;
	private String diagnosis;
	private String procedure;
	private Integer minutes;
	// can access list directly, don't need to create an object of type comments
	private List<String> comments;
	private String drAvailability;
	private Integer toFollowBoardOrder;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSurgeon() {
		return surgeon;
	}

	public void setSurgeon(String surgeon) {
		this.surgeon = surgeon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Boolean getIsInpatient() {
		return isInpatient;
	}

	public void setIsInpatient(Boolean isInpatient) {
		this.isInpatient = isInpatient;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getProcedure() {
		return procedure;
	}

	public void setProcedure(String procedure) {
		this.procedure = procedure;
	}

	public Integer getMinutes() {
		return minutes;
	}

	public void setMinutes(Integer minutes) {
		this.minutes = minutes;
	}

	public List<String> getComments() {
		return comments;
	}

	public void setComments(List<String> comments) {
		this.comments = comments;
	}

	public String getDrAvailability() {
		return drAvailability;
	}

	public void setDrAvailability(String drAvailability) {
		this.drAvailability = drAvailability;
	}

	public Integer getToFollowBoardOrder() {
		return toFollowBoardOrder;
	}

	public void setToFollowBoardOrder(Integer toFollowBoardOrder) {
		this.toFollowBoardOrder = toFollowBoardOrder;
	}

	public SurgicalCase(String surgeon, String name, String dateOfBirth, Boolean isInpatient, String diagnosis,
			String procedure, Integer minutes, List<String> comments, String drAvailability,
			Integer toFollowBoardOrder) {
		super();
		this.surgeon = surgeon;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.isInpatient = isInpatient;
		this.diagnosis = diagnosis;
		this.procedure = procedure;
		this.minutes = minutes;
		this.comments = comments;
		this.drAvailability = drAvailability;
		this.toFollowBoardOrder = toFollowBoardOrder;
	}

	public SurgicalCase() {

	}

}

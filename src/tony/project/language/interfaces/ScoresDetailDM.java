package tony.project.language.interfaces;

import tony.project.language.domain.ScoresDetail;

public interface ScoresDetailDM {

	public void saveAScore(ScoresDetail score);

	public ScoresDetail loadAScore(Integer studentID, String courseCode);

	public void deleteAScore(Integer studentID, String courseCode);

}

package csus.csc131s06.teamdeuxtwoto.gitoscar.objects;

import csus.csc131s06.teamdeuxtwoto.gitoscar.enums.AwardCategory;

public class Nomination
{
	private int nominationID, filmYear, ceremonyYear, ceremonyNumber;
	private AwardCategory awardCategory;
	private String awardedTo, filmName;
	private boolean isWinner;
	
	public Nomination(int nominationID, int filmYear, int ceremonyYear, int ceremontNumber,
			String category, String awardedTo, String filmName, boolean isWinner)
	{
		this.nominationID = nominationID;
		this.filmYear = filmYear;
		this.ceremonyYear = ceremonyYear;
		this.ceremonyNumber = ceremontNumber;
		this.awardedTo = awardedTo;
		this.filmName = filmName;
		this.isWinner = isWinner;
		
		for (AwardCategory a : AwardCategory.values())
		{
			if (a.getSQLCatKey().equals(category))
			{
				this.awardCategory = a;
				break;
			}
		}
	}
	
	public int getNominationID() { return nominationID; }	
	public int getFilmYear() { return filmYear; }
	public int getCeremonyYear() { return ceremonyYear; }
	public int getCeremonyNumber() { return ceremonyNumber; }
	public AwardCategory getCategory() { return awardCategory; }
	public String getAwardedTo() { return awardedTo; }
	public String getFilmName() { return filmName; }
	public boolean isWinner() { return isWinner; }
	public String print() { return "Film year: " + filmYear + " - " +
			"Ceremony year: " + ceremonyYear + " - " +
			"Ceremony number: " + ceremonyNumber + " - " +
			"Category: " + awardCategory.getPrint() + " - " +
			"Awarded to: " + awardedTo + " - " +
			"For film: " + filmName + " - " +
			"Winner: " + ((isWinner) ? "Yes" : "No"); }
}

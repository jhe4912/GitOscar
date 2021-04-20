package csus.csc131s06.teamdeuxtwoto.gitoscar.objects;

import csus.csc131s06.teamdeuxtwoto.gitoscar.enums.AwardCategory;

public class SearchQuery
{
	public enum AwardResult
	{
		WINNER_ONLY, NON_WINNER_ONLY, BOTH
	}
	
	private int filmYear = -1;
	private int ceremonyYear = -1;
	private int ceremonyNumber = -1;
	private AwardCategory awardCategory = null;
	private String awardedTo = null;
	private String filmName = null;
	private AwardResult includeResult = null;
	
	public void setFilmYear(int filmYear) { this.filmYear = filmYear; }
	public void setCeremonyYear(int ceremonyYear) { this.ceremonyYear = ceremonyYear; }
	public void setCeremonyNumber(int ceremonyNumber) { this.ceremonyNumber = ceremonyNumber; }
	public void setAwardCategory(AwardCategory awardCategory) { this.awardCategory = awardCategory; }
	public void setAwardedTo(String awardedTo) { this.awardedTo = awardedTo; }
	public void setFilmName(String filmName) { this.filmName = filmName; }
	public void setSearchOnlyWinners() { this.includeResult = AwardResult.WINNER_ONLY;	}
	public void setSearchOnlyNonWinners() { this.includeResult = AwardResult.NON_WINNER_ONLY; }
	public void setSearchBoth() { this.includeResult = AwardResult.BOTH; }
	
	public int getFilmYear() { return filmYear; }
	public int getCeremonyYear() { return ceremonyYear; }
	public int getCeremonyNumber() { return ceremonyNumber; }
	public AwardCategory getAwardCategory() { return awardCategory; }
	public String getAwardedTo() { return awardedTo; }
	public String getFilmName() { return filmName; }
	public AwardResult getResultsToInclude() { return includeResult; }
}

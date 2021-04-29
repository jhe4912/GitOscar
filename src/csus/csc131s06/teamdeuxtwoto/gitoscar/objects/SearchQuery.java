package csus.csc131s06.teamdeuxtwoto.gitoscar.objects;

import java.util.ArrayList;
import java.util.List;

import csus.csc131s06.teamdeuxtwoto.gitoscar.enums.AwardCategory;

public class SearchQuery
{
	public enum AwardResult
	{
		WINNER_ONLY, NON_WINNER_ONLY, BOTH
	}
	
	private int filmYearStart = 1927;
	private int filmYearEnd = 2019;
	
	private int ceremonyYear = -1;
	private int ceremonyNumber = -1;
	
	private List<AwardCategory> awardCategories = new ArrayList<>();
	
	private String awardedTo = null;
	private String filmName = null;
	
	private AwardResult includeResult = AwardResult.BOTH;
	
	public void clear() { reset(); }
	public void reset()
	{
		filmYearStart = 1927;
		filmYearEnd = 2019;
		
		ceremonyYear = -1;
		ceremonyNumber = -1;
		
		awardCategories.clear();
		
		awardedTo = null;
		filmName = null;
		
		includeResult = AwardResult.BOTH;
	}
	
	public void setFilmYearStart(int filmYearStart) { this.filmYearStart = filmYearStart; }
	public void setFilmYearEnd(int filmYearEnd) { this.filmYearEnd = filmYearEnd; }
	public void setCeremonyYear(int ceremonyYear) { this.ceremonyYear = ceremonyYear; }
	public void setCeremonyNumber(int ceremonyNumber) { this.ceremonyNumber = ceremonyNumber; }
	public void addAwardCategory(AwardCategory awardCategory) { this.awardCategories.add(awardCategory); }
	public void removeAwardCategory(AwardCategory awardCategory) { this.awardCategories.remove(awardCategory); }
	public void setAwardedTo(String awardedTo) { this.awardedTo = awardedTo; }
	public void setFilmName(String filmName) { this.filmName = filmName; }
	public void setSearchOnlyWinners() { this.includeResult = AwardResult.WINNER_ONLY;	}
	public void setSearchOnlyNonWinners() { this.includeResult = AwardResult.NON_WINNER_ONLY; }
	public void setSearchBoth() { this.includeResult = AwardResult.BOTH; }
	
	public int getFilmYearStart() { return filmYearStart; }
	public int getFilmYearEnd() { return filmYearEnd; }
	public int getCeremonyYear() { return ceremonyYear; }
	public int getCeremonyNumber() { return ceremonyNumber; }
	public List<AwardCategory> getAwardCategorys() { return awardCategories; }
	public String getAwardedTo() { return awardedTo; }
	public String getFilmName() { return filmName; }
	public AwardResult getResultsToInclude() { return includeResult; }
}

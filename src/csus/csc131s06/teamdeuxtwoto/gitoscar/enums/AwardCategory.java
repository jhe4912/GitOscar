package csus.csc131s06.teamdeuxtwoto.gitoscar.enums;

public enum AwardCategory 
{
	ACTOR ("ACTOR", "Actor"),
	ACTOR_IN_LEADING_ROLE ("ACTOR IN A LEADING ROLE", "Actor in Leading Role"),
	ACTOR_IN_SUPPORTING_ROLE ("ACTOR IN A SUPPORTING ROLE", "Actor in Supporting Role"),
	ACTRESS ("ACTRESS", "Actress"),
	ACTRESS_IN_LEADING_ROLE ("ACTRESS IN A LEADING ROLE", "Actress in Leading Role"),
	ACTRESS_IN_SUPPORTING_ROLE ("ACTRESS IN A SUPPORTING ROLE", "Actress in Supporting role"),
	ANIMATED_FEATURE_FILM ("ANIMATED FEATURE FILM", "Animated Feature Film"),
	ART_DIRECTION ("ART DIRECTION", "Art Direction"),
	ART_DIRECTION_BLACK_AND_WHITE ("ART DIRECTION (Black-and-White)", "Art Direction (Black and white)"),
	ART_DIRECTION_COLOR ("ART DIRECTION (Color)", "Art Direction (Color)"),
	ASSISTANT_DIRECTOR ("ASSISTANT DIRECTOR", "Assistant Director"),
	BEST_MOTION_PICTURE ("BEST MOTION PICTURE", "Best Motion Picture"),
	BEST_PICTURE ("BEST PICTURE", "Best Picture"),
	CINEMATOGRAPHY ("CINEMATOGRAPHY", "Cinematography"),
	CINEMATOGRAPHY_BLACK_AND_WHITE ("CINEMATOGRAPHY (Black-and-White)", "Cinematography (Black and White)"),
	CINEMATOGRAPHY_COLOR ("CINEMATOGRAPHY (Color)", "Cinematography (Color)"),
	COSTUME_DESIGN ("COSTUME DESIGN", "Costume Design"),
	COSTUME_DESIGN_BLACK_AND_WHITE ("COSTUME DESIGN (Black-and-White)", "Costume Design (Black and White)"),
	COSTUME_DESIGN_COLOR ("COSTUME DESIGN (Color)", "Costume Design (Color)"),
	DANCE_DIRECTION ("DANCE DIRECTION", "Dance Direction"),
	DIRECTING ("DIRECTING", "Directing"),
	DIRECTING_COMEDY_PICTURE ("DIRECTING (Comedy Picture)", "Directing (Comedy)"),
	DIRECTING_DRAMATIC_PICTURE ("DIRECTING (Dramatic Picture)", "Directing (Dramatic)"),
	DOCUMENTARY ("DOCUMENTARY", "Documentary"),
	DOCUMENTARY_FEATURE ("DOCUMENTARY (Feature)", "Documentary (Feature)"),
	DOCUMENTARY_SHORT_SUBJECT ("DOCUMENTARY (Short Subject)", "Documentary (Short Subject)"),
	ENGINEERING_EFFECTS ("ENGINEERING EFFECTS", "Engineering Effects"),
	FILM_EDITING ("FILM EDITING", "Film Editing"),
	FOREIGN_LANGUAGE_FILM ("FOREIGN LANGUAGE FILM", "Foreign Language Film"),
	HONORARY_AWARD ("HONORARY AWARD", "Honorary Award"),
	HONORARY_FOREIGN_LANGUAGE_AWARD ("HONORARY FOREIGN LANGUAGE FILM AWARD", "Honorary Foreign Language Film Award"),
	INTERNATIONAL_FEATURE_FILM_AWARD ("INTERNATIONAL FEATURE FILM", "International Feature Film"),
	IRVING_G_THALBERG_MEMORIAL_AWARD ("IRVING G. THALBERG MEMORIAL AWARD", "Irving G. Thalberg Memorial Award"),
	JEAN_HERSHOLT_HUMANITARIAN_AWARD ("JEAN HERSHOLT HUMANITARIAN AWARD", "Jean Hersholt Humanitarian Award"),
	MAKEUP ("MAKEUP", "Makeup"),
	MAKEUP_AND_HAIRSTYLING ("MAKEUP AND HAIRSTYLING", "Makeup and Hairstyling"),
	MUSIC_ADAPTATION_SCORE ("MUSIC (Adaptation Score)", "Music (Adaptation Score)"),
	MUSIC_SCORE_OF_A_DRAMATIC_PICTURE ("MUSIC (Music Score of a Dramatic Picture)", "Music (Score of a Dramatic Picture)"),
	MUSIC_SCORE_OF_A_DRAMATIC_OR_COMEDY_PICTURE ("MUSIC (Music Score of a Dramatic or Comedy Picture)", "Music (Score of a Dramatic/Comedy Picture)"),
	MUSIC_SCORE_SUBSTANTIALLY_ORGINAL ("MUSIC (Music Score--substantially original)", "Music (Substantially Original Score)"),
	MUSIC_ORIGINAL_DRAMATIC_SCORE ("MUSIC (Original Dramatic Score)", "Music (Original Dramatic Score)"),
	MUSIC_ORIGINAL_MUSIC_SCORE ("MUSIC (Original Music Score)", "Music (Original Music Score)"),
	MUSIC_ORIGINAL_MUSICAL_OR_COMEDY_SCORE ("MUSIC (Original Musical or Comedy Score)", "Music (Original Musical/Comedy Score)"),
	MUSIC_ORIGINAL_SCORE ("MUSIC (Original Score)", "Music (Original Score)"),
	MUSIC_ORIGINAL_FOR_MOTION_PICTURE ("MUSIC (Original Score--for a motion picture [not a musical])", "Music (Original Score for Non-musical Motion Picture)"),
	MUSIC_ORIGINAL_SONG_SCORE_AND_ITS_ADAPTATION ("MUSIC (Original Song Score and Its Adaptation or Adaptation Score)", "Music (Original Song Score and Its Adaptation or Adaptation Score)"),
	MUSIC_ORIGINAL_SONG_OR_ADAPTATION_SCORE ("MUSIC (Original Song Score or Adaptation Score)", "Music (Original Song/Adaptation Score)"),
	MUSIC_ORIGINAL_SONG_SCORE ("MUSIC (Original Song Score)", "Music (Original Song Score)"),
	MUSIC_ORIGINAL_SONG ("MUSIC (Original Song)", "Music (Original Song)"),
	MUSIC_SCORE_OF_A_MUSICAL_PICTURE_ORIGINAL_OR_ADAPTATION ("MUSIC (Score of a Musical Picture--original or adaptation)", "Music (Original/Adaptation Score of a Musical Picture.)"),
	MUSIC_SCORING_OF_MUSIC_ADAPTATION_OR_TREATMENT ("MUSIC (Scoring of Music--adaptation or treatment)", "Music (Adaptation/Treatment Scoring of Music)"),
	MUSIC_SCORING_OF_A_MUSICAL_PICTURE ("MUSIC (Scoring of a Musical Picture)", "Music (Scoring of a Musical Picture)"),
	MUSIC_SCORING ("MUSIC (Scoring)", "Music (Scoring)"),
	MUSIC_SCORING_ADAPTATION_AND_ORIGINAL_SONG_SCORE ("MUSIC (Scoring: Adaptation and Original Song Score)", "Music (Scoring: Adaptation and Original Song Score)"),
	MUSIC_SCORING_ADAPTATION ("MUSIC (Scoring: Original Song Score and Adaptation -or- Scoring: Adaptation)", "Music (Scoring: Adaptation/Original Song Score)"),
	MUSIC_SONG ("MUSIC (Song)", "Music (Song)"),
	MUSIC_SONG_ORIGINAL_FOR_THE_PICTURE ("MUSIC (Song--Original for the Picture)", "Music (Original Song for the Picture)"),
	OUTSTANDING_MOTION_PICTURE ("OUTSTANDING MOTION PICTURE", "Outstanding Motion Picture"),
	OUTSTANDING_PICTURE ("OUTSTANDING PICTURE", "Outstanding Picture"),
	OUTSTANDING_PRODUCTION ("OUTSTANDING PRODUCTION", "Outstanding Production"),
	PRODUCTION_DESIGN ("PRODUCTION DESIGN", "Production Design"),
	SHORT_FILM_ANIMATED ("SHORT FILM (Animated)", "Short Film (Animated)"),
	SHORT_FILM_DRAMATIC_LIVE_ACTION ("SHORT FILM (Dramatic Live Action)", "Short Film (Dramatic Live Action)"),
	SHORT_FILM_LIVE_ACTION ("SHORT FILM (Live Action)", "Short Film (Live Action)"),
	SHORT_SUBJECT_ANIMATED ("SHORT SUBJECT (Animated)", "Short Subject (Animated)"),
	SHORT_SUBJECT_CARTOON ("SHORT SUBJECT (Cartoon)", "Short Subject (Cartoon)"),
	SHORT_SUBJECT_COLOR ("SHORT SUBJECT (Color)", "Short Subject (Color)"),
	SHORT_SUBJECT_COMEDY ("SHORT SUBJECT (Comedy)", "Short Subject (Comedy)"),
	SHORT_SUBJECT_LIVE_ACTION ("SHORT SUBJECT (Live Action)", "Short Subject (Live Action)"),
	SHORT_SUBJECT_NOVELTY ("SHORT SUBJECT (Novelty)", "Short Subject (Novelty)"),
	SHORT_SUBJECT_ONE_REEL ("SHORT SUBJECT (One-reel)", "Short Subject (One-reel)"),
	SHORT_SUBJECT_TWO_REEL ("SHORT SUBJECT (Two-reel)", "Short Subject (Two-reel)"),
	SOUND ("SOUND", "Sound"),
	SOUND_EDITING ("SOUND EDITING", "Sound Editing"),
	SOUND_EFFECTS ("SOUND EFFECTS", "Sound Effects"),
	SOUND_EFFECTS_EDITNG ("SOUND EFFECTS EDITING", "Sound Effects Editing"),
	SOUND_MIXING ("SOUND MIXING", "Sound Mixing"),
	SOUND_RECORDING ("SOUND RECORDING", "Sound Recording"),
	SPECIAL_ACHIEVEMENT_AWARD ("SPECIAL ACHIEVEMENT AWARD", "Special Achievement Award"),
	SPECIAL_ACHIEVEMENT_AWARD_SOUND_EDITING ("SPECIAL ACHIEVEMENT AWARD (Sound Editing)", "Special Achievement Award (Sound Editing)"),
	SPECIAL_ACHIEVEMENT_AWARD_SOUND_EFFECTS_EDITING ("SPECIAL ACHIEVEMENT AWARD (Sound Effects Editing)", "Special Achievement Award (Sound Effects Editing)"),
	SPECIAL_ACHIEVEMENT_AWARD_SOUND_EFFECTS ("SPECIAL ACHIEVEMENT AWARD (Sound Effects)", "Special Achievement Award (Sound Effects)"),
	SPECIAL_ACHIEVEMENT_AWARD_VISUAL_EFFECTS ("SPECIAL ACHIEVEMENT AWARD (Visual Effects)", "Special Achievement Award (Visual Effects)"),
	SPECIAL_AWARD ("SPECIAL AWARD", "Special Award"),
	SPECIAL_EFFECTS ("SPECIAL EFFECTS", "Special Effects"),
	SPEICAL_FOREIGN_LANGUAGE_FILM_AWARD ("SPECIAL FOREIGN LANGUAGE FILM AWARD", "Special Foreign Language Film Award"),
	SPECIAL_VISUAL_EFFECTS ("SPECIAL VISUAL EFFECTS", "Special Visual Effects"),
	UNIQUE_AND_ARTISTIC_PICTURE ("UNIQUE AND ARTISTIC PICTURE", "Unique and Artistic Picture"),
	VISUAL_EFFECTS ("VISUAL EFFECTS", "Visual Effects"),
	WRITING ("WRITING", "Writing"),
	WRITING_ADAPTATION ("WRITING (Adaptation)", "Writing (Adaptation)"),
	WRITING_ADAPTED_SCREENPLAY ("WRITING (Adapted Screenplay)", "Writing (Adapted Screenplay)"),
	WRITING_MOTION_PICTURE_STORY ("WRITING (Motion Picture Story)", "Writing (Motion Picture Story)"),
	WRITING_ORIGINAL_MOTION_PICTURE_STORY ("WRITING (Original Motion Picture Story)", "Writing (Original Motion Picture Story)"),
	WRITING_ORIGINAL_SCREENPLAY ("WRITING (Original Screenplay)", "Writing (Original Screenplay)"),
	WRITING_ORIGINAL_STORY ("WRITING (Original Story)", "Writing (Original Story)"),
	WRITING_SCREENPLAY_ADAPTED_FROM_OTHER_MATERIAL ("WRITING (Screenplay Adapted from Other Material)", "Writing (Screenplay Adapted from Other Material)"),
	WRITING_SCREENPLAY_BASED_ON_MATERIAL_PREVIOUSLY_PRODUCED_OR_PUBLISHED ("WRITING (Screenplay Based on Material Previously Produced or Published)", "Writing (Screenplay Based on Material Previously Produced or Published)"),
	WRITING_SCREENPLAY_BASED_ON_MATERIAL_FROM_ANOTHER_MEDIUM ("WRITING (Screenplay Based on Material from Another Medium)", "Writing (Screenplay Based on Material from Another Medium)"),
	WRITING_SCREENPLAY_WRITTEN_DRIECTLY_FOR_THE_SCREEN ("WRITING (Screenplay Written Directly for the Screen)", "Writing (Screenplay Written Directly for the Screen)"),
	WRITING_SCREENPLAY_WRITTEN_DRIECTLY_FOR_THE_SCREEN_BASED_ON_FACTUAL_OR_STORY_MATERIAL ("WRITING (Screenplay Written Directly for the Screen--based on factual material or on story material not previously published or produced)", "Writing (Screenplay Written Directly for the Screen Based on Material or on Story Material not Previously Published/Produced)"),
	WRITING_SCREENPLAY ("WRITING (Screenplay)", "Writing (Screenplay)"),
	WRITING_SCREENPLAY_ADAPTED ("WRITING (Screenplay--Adapted)", "Writing (Adapted Screenplay)"),
	WRITING_SCREENPLAY_ORIGINAL ("WRITING (Screenplay--Original)", "Writing (Original Screenplay)"),
	WRITING_STORY_AND_SCREENPLAY ("WRITING (Story and Screenplay)", "Writing (Story and Screenplay)"),
	WRITING_STORY_AND_SCREENPLAY_BASED_ON_FACTUAL_MATERIAL_NOT_PREVIOUSLY_PUBLISHED_OR_PRODUCED ("WRITING (Story and Screenplay--based on factual material or material not previously published or produced)", "Writing (Story and Screenplay Based on Factual Material or Material not Previously Published/Produced)"),
	WRITING_STORY_AND_SCREENPLAY_BASED_ON_MATERIAL_NOT_PREVIOUSLY_PUBLISHED_OR_PRODUCED ("WRITING (Story and Screenplay--based on material not previously published or produced)", "Writing (Story and Screenplay Based on Material not Previously Published/Produced)"),
	WRITING_STORY_AND_SCREENPLAY_WRITTEN_DIRECTLY_FOR_THE_SCREEN ("WRITING (Story and Screenplay--written directly for the screen)", "Writing (Story and Screenplay Written Directly for the Screen)"),
	WRITING_TITLE_WRITING ("WRITING (Title Writing)", "Writing (Title Writing)");
	
	private final String sqlCatKey, print;
	
	AwardCategory(String sqlCatKey, String print)
	{
		this.sqlCatKey = sqlCatKey;
		this.print = print;
	}
	
	public String getSQLCatKey() { return sqlCatKey; }
	public String getPrint() { return print; }
	
	public static String[] getAllAwardPrint()
	{
		String[] awardsPrint = new String[AwardCategory.values().length];
		int counter = 0;
		for (AwardCategory a : AwardCategory.values())
		{
			awardsPrint[counter] = a.getPrint();
			counter++;
		}
		
		return awardsPrint;
	}
	
	public static AwardCategory getAwardCategoryFromPrint(String print)
	{
		for (AwardCategory a : AwardCategory.values())
			if (a.getPrint().equals(print)) return a;
		return null;
	}
}

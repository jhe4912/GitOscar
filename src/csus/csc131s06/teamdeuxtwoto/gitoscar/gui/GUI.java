package csus.csc131s06.teamdeuxtwoto.gitoscar.gui;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

import csus.csc131s06.teamdeuxtwoto.gitoscar.Main;
import csus.csc131s06.teamdeuxtwoto.gitoscar.enums.AwardCategory;
import csus.csc131s06.teamdeuxtwoto.gitoscar.objects.Nomination;
import csus.csc131s06.teamdeuxtwoto.gitoscar.objects.SearchQuery;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;

/*
 *  From Jason, Most of this code is generated code from Eclipse WindowBuilder.
 *  I take zero credit aside from modifications to the code for fit or code that
 *  WindowBuilder can't do correctly.
 */

public class GUI
{
	private JList<String> awardsList;
	private JRadioButton bothRButton;
	private JSpinner filmYearStartSpinner, filmYearEndSpinner;
	private JTextArea resultsTextArea;
	
	private JFrame currentFrame, searchFrame, resultsFrame;
	private final ButtonGroup includeResultsBG = new ButtonGroup();
	private SearchQuery searchQuery = new SearchQuery();
	
	public GUI()
	{
		searchFrame();
		resultFrame();
		
		searchFrame.setVisible(true);
		currentFrame = searchFrame;
	}
	
	private void searchFrame()
	{
		searchFrame = new JFrame("GitOscar - Search");
		searchFrame.setSize(750, 550);
		searchFrame.setLocationRelativeTo(null);
		searchFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		searchFrame.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				Main.end();
			}
		});
		
		JMenuBar menuBar = new JMenuBar();		
		menuBar.add(new JButton("Home"));
		menuBar.add(new JButton("Search"));
		menuBar.add(new JButton("About"));	
		searchFrame.setJMenuBar(menuBar);
				
		JPanel includeResultsPanel = new JPanel();
		includeResultsPanel.setBorder(new TitledBorder(null, "Include Result", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel filmYearPanel = new JPanel();
		filmYearPanel.setBorder(new TitledBorder(null, "Film Year", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel awardListPanel = new JPanel();
		awardListPanel.setBorder(new TitledBorder(null, "Select Awards (Hold control (ctrl) to select multipl. Select none for all..)", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		awardListPanel.setLayout(new CardLayout(0, 0));
		
		JButton resetButton = new JButton("Reset");
		JButton searchButton = new JButton("Search");
		
		GroupLayout groupLayout = new GroupLayout(searchFrame.getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(filmYearPanel, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(awardListPanel, GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(includeResultsPanel, GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(searchButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(resetButton, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))))
						.addGap(8)));
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
					.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(filmYearPanel, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
							.addComponent(awardListPanel, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(resetButton)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(searchButton)
								.addGap(9))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(includeResultsPanel, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()))));
		searchFrame.getContentPane().setLayout(groupLayout);
		
		awardListPanel.setLayout(new CardLayout(0, 0));
		
		JScrollPane awardsListScrollPane = new JScrollPane();
		awardListPanel.add(awardsListScrollPane, "name_43380513505500");
		
		awardsList = new JList<String>(AwardCategory.getAllAwardPrint());
		awardsList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		awardsList.setLayoutOrientation(JList.VERTICAL);
		
		awardsListScrollPane.setViewportView(awardsList);
		
		JLabel filmYearStartLabel = new JLabel("Start");
		filmYearStartSpinner = new JSpinner();
		filmYearStartSpinner.setModel(new SpinnerNumberModel(
				1927, 1927, 2019, 1));
		filmYearStartSpinner.setEditor(
				new JSpinner.NumberEditor(filmYearStartSpinner, "#"));
		
		
		JLabel filmYearEndLabel = new JLabel("End");
		filmYearEndSpinner = new JSpinner();
		filmYearEndSpinner.setModel(new SpinnerNumberModel(
				2019, 1927, 2019, 1));
		filmYearEndSpinner.setEditor(
				new JSpinner.NumberEditor(filmYearEndSpinner, "#"));
		
		filmYearPanel.setLayout(new BoxLayout(filmYearPanel, BoxLayout.Y_AXIS));
		filmYearPanel.add(filmYearStartLabel);
		filmYearPanel.add(filmYearStartSpinner);
		filmYearPanel.add(filmYearEndLabel);
		filmYearPanel.add(filmYearEndSpinner);
		
		includeResultsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JRadioButton nWinnerRButton = new JRadioButton("Non-Winners Only");
		JRadioButton winnerRButton = new JRadioButton("Winners Only");
		this.bothRButton = new JRadioButton("Both", true);
		
		includeResultsBG.add(nWinnerRButton);
		includeResultsBG.add(winnerRButton);
		includeResultsBG.add(bothRButton);
		
		includeResultsPanel.add(nWinnerRButton);
		includeResultsPanel.add(winnerRButton);
		includeResultsPanel.add(bothRButton);
		
		nWinnerRButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent event) 
			{
				searchQuery.setSearchOnlyNonWinners();
			}
		});
		
		winnerRButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent event) 
			{
				searchQuery.setSearchOnlyWinners();
			}
		});
		
		bothRButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent event) 
			{
				searchQuery.setSearchBoth();
			}
		});
		
		resetButton.addActionListener(new ActionListener()
		{	
			@Override
			public void actionPerformed(ActionEvent event)
			{
				resetSearchFrame();
			}
		});
		
		searchButton.addActionListener(new ActionListener()
		{	
			@Override
			public void actionPerformed(ActionEvent event)
			{
				openResearchFrame();
			}
		});
	}
	
	private void openSearchFrame()
	{
		resetSearchFrame();
		currentFrame.setVisible(false);
		searchFrame.setVisible(true);
		currentFrame = searchFrame;
	}
	
	private void resetSearchFrame()
	{
		searchQuery.clear();
		includeResultsBG.clearSelection();
		bothRButton.setSelected(true);
		filmYearStartSpinner.setValue(1927);
		filmYearEndSpinner.setValue(2019);
		awardsList.clearSelection();
	}
	
	private void resultFrame()
	{
		resultsFrame = new JFrame("GitOscar - Search Results");
		resultsFrame.setSize(750, 550);
		resultsFrame.setLocationRelativeTo(null);
		resultsFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		resultsFrame.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				Main.end();
			}
		});
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(new JButton("Home"));
		menuBar.add(new JButton("Search"));
		menuBar.add(new JButton("About"));
		resultsFrame.setJMenuBar(menuBar);
		
		JPanel resultsPanel = new JPanel();
		resultsPanel.setBorder(new TitledBorder(null, "Results", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton newSearchButton = new JButton("New Search");
		GroupLayout groupLayout = new GroupLayout(resultsFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(resultsPanel, GroupLayout.PREFERRED_SIZE, 733, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(622, Short.MAX_VALUE)
					.addComponent(newSearchButton)
					.addGap(23))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(resultsPanel, GroupLayout.PREFERRED_SIZE, 447, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(newSearchButton)
					.addContainerGap())
		);
		resultsPanel.setLayout(new CardLayout(0, 0));
		resultsFrame.getContentPane().setLayout(groupLayout);
		
		resultsTextArea = new JTextArea("No Results Found");
		resultsTextArea.setEditable(false);
		
		JScrollPane resultsListScrollPane = new JScrollPane();
		resultsPanel.add(resultsListScrollPane, "name_50183210810900");
		resultsListScrollPane.setViewportView(resultsTextArea);
		
		newSearchButton.addActionListener(new ActionListener()
		{	
			@Override
			public void actionPerformed(ActionEvent event)
			{
				openSearchFrame();
			}
		});
	}
	
	private void openResearchFrame()
	{
		currentFrame.setVisible(false);
		resultsFrame.setVisible(true);
		currentFrame = resultsFrame;
		
		if (!awardsList.getSelectedValuesList().isEmpty())
		{
			for (String s : awardsList.getSelectedValuesList())
				if (AwardCategory.getAwardCategoryFromPrint(s) != null) 
					searchQuery.addAwardCategory(AwardCategory.getAwardCategoryFromPrint(s));
		}
		else
		{
			for (AwardCategory a : AwardCategory.values())
				searchQuery.addAwardCategory(a);
		}
		
		searchQuery.setFilmYearStart((int) filmYearStartSpinner.getValue());
		searchQuery.setFilmYearEnd((int) filmYearEndSpinner.getValue());
		
		try
		{	
			List<Nomination> nominations = Main.getSQLHandler().getAwardsFromSearchQuery(searchQuery);
			
			if (nominations != null)
			{
				resultsTextArea.setText("");
				StringBuilder sb = new StringBuilder();
				
				for (Nomination n : nominations)
					sb.append(n.print() + "\n");
				
				sb.delete(sb.length() - 1, sb.length());
				resultsTextArea.append(sb.toString());
				resultsTextArea.setCaretPosition(0);
			}
			else
			{
				resultsTextArea.setText("No Results Found.");
				resultsTextArea.setCaretPosition(0);
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}

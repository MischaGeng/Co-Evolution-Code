package translationApp;

import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;


public class StartWindow extends ApplicationWindow
{


	private Text text_ef;
	private Text text_hf;
	private Text text_cf;

	/**
	 * Create the application window.
	 */
	public StartWindow()
	{
		super(null);
		createActions();
		addStatusLine();
	}

	/**
	 * Create contents of the application window.
	 * @param parent
	 */
	@Override
	protected Control createContents(Composite parent)
	{
		Composite container = new Composite(parent, SWT.NONE);
		
		Label lblEcoreFile = new Label(container, SWT.NONE);
		lblEcoreFile.setBounds(10, 10, 62, 15);
		lblEcoreFile.setText("Ecore File");
		
		text_ef = new Text(container, SWT.BORDER);
		text_ef.setBounds(10, 31, 294, 21);
		
		Shell shell = new Shell(SWT.CLOSE);
		shell.setLayout(new FillLayout());
		
		Button btn_im_ef = new Button(container, SWT.NONE);
		btn_im_ef.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fileDialog = new FileDialog(shell);
				String fileIn = fileDialog.open();
				text_ef.setText(fileIn);
			}
		});
		btn_im_ef.setBounds(324, 29, 75, 25);
		btn_im_ef.setText("Import");
		
		Label lblHistoryFile = new Label(container, SWT.NONE);
		lblHistoryFile.setBounds(10, 58, 75, 15);
		lblHistoryFile.setText("History File");
		
		text_hf = new Text(container, SWT.BORDER);
		text_hf.setBounds(10, 79, 294, 21);
		
		Button btn_im_hf = new Button(container, SWT.NONE);
		btn_im_hf.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fileDialog = new FileDialog(shell);
				String fileIn = fileDialog.open();
				text_hf.setText(fileIn);
			}
		});
		btn_im_hf.setBounds(324, 77, 75, 25);
		btn_im_hf.setText("Import");
		
		Label lblChangelogFile = new Label(container, SWT.NONE);
		lblChangelogFile.setBounds(10, 116, 102, 15);
		lblChangelogFile.setText("Changelog File");
		
		text_cf = new Text(container, SWT.BORDER);
		text_cf.setBounds(10, 139, 294, 21);
		
		Button btn_ex_cf = new Button(container, SWT.NONE);
		btn_ex_cf.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fileDialog = new FileDialog(shell);
				String fileIn = fileDialog.open();
				text_cf.setText(fileIn);
			}
		});
		btn_ex_cf.setBounds(324, 135, 75, 25);
		btn_ex_cf.setText("Export");
		
		Button btn_run = new Button(container, SWT.NONE);
		btn_run.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				LoadFileInWin load = new  LoadFileInWin();
				try
				{
					load.LoadFile(text_ef.getText(),text_hf.getText(),text_cf.getText());
				} catch (Exception e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
			}
		});
		btn_run.setBounds(106, 184, 75, 25);
		btn_run.setText("Run");
		
		Button btn_exit = new Button(container, SWT.NONE);
		btn_exit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.exit(0);
			}
		});
		btn_exit.setBounds(239, 184, 75, 25);
		btn_exit.setText("Exit");

		return container;
	}

	/**
	 * Create the actions.
	 */
	private void createActions()
	{
		// Create the actions
	}

	/**
	 * Create the menu manager.
	 * @return the menu manager
	 */


	@Override
	protected StatusLineManager createStatusLineManager()
	{
		StatusLineManager statusLineManager = new StatusLineManager();
		return statusLineManager;
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[])
	{
		try
		{
			StartWindow window = new StartWindow();
			window.setBlockOnOpen(true);
			window.open();
			Display.getCurrent().dispose();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Configure the shell.
	 * @param newShell
	 */
	@Override
	protected void configureShell(Shell newShell)
	{
		super.configureShell(newShell);
		newShell.setText("Translation Application");
	}

	/**
	 * Return the initial size of the window.
	 */
	@Override
	protected Point getInitialSize()
	{
		return new Point(451, 285);
	}
}

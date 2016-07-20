public class LoginDialogController
{
    private JFrame _owner;
    private JDialog _dialog;
    private JTextField _fUsername;
    private JPasswordField _fPassword;
    private Action _aLogin;
    private Action _aCancel;

    public LoginDialogController(JFrame owner)
    {
        _owner = owner;
    }

    public void show()
    {
        if (_dialog == null)
            constructDialog();
        _dialog.setVisible(true);
    }

    private void constructDialog()
    {
        // constructs the dialog and sets all instance variables
    }

    private class LoginAction
    extends AbstractAction
    {
        // ...

        public void actionPerformed(ActionEvent e)
        {
            // all of the actual login logic goes here
            _dialog.dispose();
        }
    }

    private class CancelAction
    extends AbstractAction
    {
        // ...

        public void actionPerformed(ActionEvent e)
        {
            _dialog.dispose();
        }
    }

///------
public static void main(String[] argv)
throws Exception
{
    final MainFrameController controller = new MainFrameController();
    SwingUtilities.invokeAndWait(new Runnable()
    {
        public void run()
        {
            controller.show();
        }
    });
}

}

//----

// this is legacy code, which subclasses JPanel
frame.setContentPane(new MyContentPane());

// we add a controller instance that only exists long enough to
// create the actual panel
frame.setContentPane(new ContentController().create,());
Frames and dialogs take a little more work, but not much: whatever
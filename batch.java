
package ShortcutCreator;

import java.io.*;

/**
 *
 * @author Ced the great
 */
public class batch {
    
    public batch(String folder,String javapack,String javaapp,String ico) throws IOException{
        
        FileWriter temp=new FileWriter(folder+"\\setup.bat");
        BufferedWriter out=new BufferedWriter(temp);
        
        out.write("@echo off");
        out.write("\r\n");
  out.write("\r\nFOR /F \"usebackq delims=\" %%i in (`cscript findDesktop.vbs`) DO SET DESKTOPDIR=%%i");
        out.write("\r\nSET NAME=" + javaapp);
        out.write("\r\nSET PACK=" + javapack);
        out.write("\r\nSET APP=" + javaapp);
        out.write("\r\nSET ICO=" + ico);
        out.write("\r\n");
        out.write("\r\nset SCRIPT=\"%TEMP%\\%RANDOM%-%RANDOM%-%RANDOM%-%RANDOM%.vbs\"");
        out.write("\r\necho Set oWS = WScript.CreateObject(\"WScript.Shell\") >> %SCRIPT%");
        out.write("\r\necho sLinkFile = \"%DESKTOPDIR%\\%NAME%.lnk\" >> %SCRIPT%");
        out.write("\r\necho Set oLink = oWS.CreateShortcut(sLinkFile) >> %SCRIPT%");
        out.write("\r\necho oLink.TargetPath = \"%SystemRoot%\\System32\\javaw.exe\" >> %SCRIPT%");
        out.write("\r\necho oLink.Arguments = \"%PACK%/%APP%\" >> %SCRIPT%");
        out.write("\r\necho oLink.WorkingDirectory = \"%~dp0\" >> %SCRIPT%");
        out.write("\r\necho oLink.IconLocation = \"%~dp0\\%ico%.ico\" >> %SCRIPT%");
        out.write("\r\necho oLink.Save >> %SCRIPT%");
        out.write("\r\ncscript /nologo %SCRIPT%");
        out.write("\r\ndel %SCRIPT%");
	out.close();
        
        
        FileWriter temp1=new FileWriter(folder+"\\findDesktop.vbs");
        BufferedWriter out2=new BufferedWriter(temp1);
        
        out2.write("set WshShell = WScript.CreateObject(\"WScript.Shell\")");
        out2.write("\r\nstrDesktop = WshShell.SpecialFolders(\"Desktop\")");
	out2.write("\r\nwscript.echo(strDesktop)");
	out2.close();
        
    }
    
}

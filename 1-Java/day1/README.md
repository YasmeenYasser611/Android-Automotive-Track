# Java Day1:

after install JDK8 :

 > export PATH=/home/yasmeen/java/jdk-8u431-linux-i586/jdk1.8.0_431/bin:$PATH

>export PATH=/home/yasmeen/java/jdk-8u431-linux-x64/jdk1.8.0_431/bin:$PATH  ---new one for jfx


helloworld.java
``` java 
package mypkg;

class Hello
{
	public static void main(String[] args)
	{
		//System.out.println("Hello , Yasmeen say Hiii!!!!!!!!");
		if (args.length > 0) 
		{
                	System.out.println(args[0]);
                } 
                else 
                {
                 	System.out.println("No argument provided!");
                	System.out.println("Hello , Yasmeen say Hiii!!!!!!!!");
                }
	}

}

```
# Without Package :
    > javac helloworld.java 

    > java Hello   (using the class name which contain main method)

## if creating jar file
    > javac helloworld.java 
    
    > jar cef Hello myjar.jar Hello.class 

    > java -jar myjar.jar

# using package :
    > javac -d . helloworld.java 

    > java mypkg.Hello 

## if creating jar file

    > javac -d . helloworld.java 
    
    > jar cef mypkg.Hello  myJar.jar mypkg/Hello.class 

    > java -jar myJar.jar ------> will print the defult

    > java -jar myJar.jar "Yasmeen" -------------> will print hte passed argument


# Applets:

object creation -> init() -> start() -> paint() -> stop() -> destroy() .


HelloApplet.java

``` java 
import java.applet.Applet;
import java.awt.Graphics;
public class HelloApplet extends Applet
{
	public void paint(Graphics g)
	{
		g.drawString("Yasmeen Say HIII!!!", 50 , 100);
		String name = getParameter("Name");
		System.out.println( name );

	}


}

```

HelloApplet.html
```  html 
<html>
	<body>
		<applet code ="HelloApplet" width='500' height='500'>
		<param name=Name value="Yasmeen">
		</applet>
	</body>

</html>

```


## for Running

> javac HelloApplet.java 

> appletviewer HelloApplet.html 


package manager;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjectManager {

	protected WebDriver driver;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public <Tpage> Tpage getPageInstance(Class<Tpage> pageClass) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException
	{
		Tpage page = null;
		
		if(page==null){
			page = pageClass.getDeclaredConstructor().newInstance();
			PageFactory.initElements(this.driver, page);	
		}
		return page;
	}
}

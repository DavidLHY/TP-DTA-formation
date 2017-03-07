
package fr.pizzeria.ihm;

import java.util.Map;

import fr.pizzeria.ihm.menu.option.DeleteOptionMenu;
import fr.pizzeria.ihm.menu.option.ExitOptionMenu;
import fr.pizzeria.ihm.menu.option.GroupedPrintedOptionMenu;
import fr.pizzeria.ihm.menu.option.OptionMenu;
import fr.pizzeria.ihm.menu.option.PrintedOptionMenu;
import fr.pizzeria.ihm.menu.option.PrixMaxOptionMenu;
import fr.pizzeria.ihm.menu.option.SaveOptionMenu;
import fr.pizzeria.ihm.menu.option.UpdateOptionMenu;

public class Menu extends MenuAbs {

	public Menu() {
		listOptions.put(1, new PrintedOptionMenu());
		listOptions.put(2, new SaveOptionMenu());
		listOptions.put(3, new UpdateOptionMenu());
		listOptions.put(4, new DeleteOptionMenu());
		listOptions.put(5, new GroupedPrintedOptionMenu());
		listOptions.put(6, new PrixMaxOptionMenu());
		listOptions.put(99, new ExitOptionMenu());

	}

	public Map<Integer, OptionMenu> getMapOptions() {
		return listOptions;
	}

	public void setListOptions(Map<Integer, OptionMenu> listOptions) {
		this.listOptions = listOptions;
	}

}

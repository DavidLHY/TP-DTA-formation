package fr.pizzeria.ihm;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import org.reflections.Reflections;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.ihm.menu.option.OptionMenu;
import fr.pizzeria.ihm.menu.option.TagOptionMenu;

public class MenuReflection extends MenuAbs {

	public MenuReflection(String titre, Scanner scanner, Map<Integer, OptionMenu> listOptions) {
		super(titre, scanner, listOptions);
		
	}

	
	
	
	/*public MenuReflection() {

		Reflections reflections = new Reflections("fr.pizzeria.ihm");

		Set<Class<? extends OptionMenu>> optionMenuClass = reflections.getSubTypesOf(OptionMenu.class);

		List<? extends OptionMenu> listOption = optionMenuClass.stream()
				.filter(omClass -> omClass.getAnnotation(TagOptionMenu.class) != null).map(omCls -> {
					try {
						return omCls.newInstance();
					} catch (Exception e) {
						throw new DaoException("menu vide",e);
						
					}
				}).collect(Collectors.toList());

		for (int i = 0; i < listOption.size(); i++) {

			listOptions.put(i, listOption.get(i));
		}

	}*/

}

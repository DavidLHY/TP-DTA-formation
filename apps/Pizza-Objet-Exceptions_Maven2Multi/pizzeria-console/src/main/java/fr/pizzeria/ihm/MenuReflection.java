package fr.pizzeria.ihm;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.reflections.Reflections;

import fr.pizzeria.ihm.menu.option.OptionMenu;
import fr.pizzeria.ihm.menu.option.TagOptionMenu;

public class MenuReflection extends MenuAbs {

	public MenuReflection() {

		Reflections reflections = new Reflections("fr.pizzeria.ihm");

		Set<Class<? extends OptionMenu>> optionMenuClass = reflections.getSubTypesOf(OptionMenu.class);

		List<? extends OptionMenu> listOption = optionMenuClass.stream()
				.filter(omClass -> omClass.getAnnotation(TagOptionMenu.class) != null).map(omCls -> {
					try {
						return omCls.newInstance();
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
				}).collect(Collectors.toList());

		for (int i = 0; i < listOption.size(); i++) {

			listOptions.put(i, listOption.get(i));
		}

	}

}

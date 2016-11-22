package io.toast.tk.plugin.example;

import java.util.Arrays;
import java.util.Collection;

import com.google.inject.Module;

import io.toast.tk.core.guice.AbstractActionAdapterModule;
import io.toast.tk.plugin.IAgentPlugin;

public class PluginExample implements IAgentPlugin {

	@Override
	public void boot() {
		//NO-OP
	}

	@Override
	public Collection<? extends Module> getModules() {
		Module module = new AbstractActionAdapterModule() {
			@Override
			protected void configure() {
				bindActionAdapter(WebActionAdapter.class);			
			}
		};
		return Arrays.asList(module);
	}

}

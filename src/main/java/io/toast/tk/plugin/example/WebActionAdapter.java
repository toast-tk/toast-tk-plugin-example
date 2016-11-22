package io.toast.tk.plugin.example;

import com.google.inject.Inject;

import io.toast.tk.adapter.web.AbstractWebActionAdapter;
import io.toast.tk.core.adapter.ActionAdapterKind;
import io.toast.tk.core.annotation.ActionAdapter;
import io.toast.tk.runtime.IActionItemRepository;

@ActionAdapter(name="web-adapter-plugin-example",value = ActionAdapterKind.web)
public class WebActionAdapter extends AbstractWebActionAdapter {

	@Inject
	public WebActionAdapter(IActionItemRepository repository) {
		super(repository);
	}

}

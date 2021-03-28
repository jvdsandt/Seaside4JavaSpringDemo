package com.cloudctrl.seaside.tags;

import com.cloudctrl.seaside.document.HtmlScriptElement;

public class ScriptTag extends TagBrush<ScriptTag> {

    @Override
    public String getTag() {
        return "script";
    }

    public ScriptTag setUrl(String anUrl) {
        attributePut("src", anUrl);
        return this;
    }

    public ScriptTag setIntegrity(String hash) {
        attributePut("integrity", hash);
        return this;
    }

    public ScriptTag beAnonymous() {
        attributePut("crossorigin", "anonymous");
        return this;
    }


}

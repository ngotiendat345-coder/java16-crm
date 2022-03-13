package cybersoft.javabackend.crm.filter;

import javax.servlet.annotation.WebFilter;

import cybersoft.javabackend.crm.util.UrlConst;
import com.opensymphony.sitemesh.webapp.SiteMeshFilter;

@WebFilter(displayName = "sitemesh", urlPatterns = UrlConst.GLOBAL)
public class LayoutFilter extends SiteMeshFilter {
	
}

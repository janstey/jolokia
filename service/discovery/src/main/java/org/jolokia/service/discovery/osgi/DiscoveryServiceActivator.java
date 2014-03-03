package org.jolokia.service.discovery.osgi;

import org.jolokia.server.core.service.api.JolokiaService;
import org.jolokia.service.discovery.DiscoveryMulticastResponder;
import org.jolokia.service.discovery.JolokiaDiscovery;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * Simple activator for creating a JMX request handler
 *
 * @author roland
 * @since 02.03.14
 */
public class DiscoveryServiceActivator implements BundleActivator {

    /** {@inheritDoc} */
    public void start(BundleContext context) throws Exception {
        context.registerService(JolokiaService.Init.class.getName(),new JolokiaDiscovery(0),null);
        context.registerService(JolokiaService.Init.class.getName(),new DiscoveryMulticastResponder(),null);
    }

    /** {@inheritDoc} */
    public void stop(BundleContext context) throws Exception { }
}

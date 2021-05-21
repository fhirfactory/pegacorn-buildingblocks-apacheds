package net.fhirfactory.pegacorn.buildingblocks.apacheds;

import java.io.IOException;

import org.apache.directory.api.ldap.model.exception.LdapException;
import org.apache.directory.ldap.client.api.LdapConnection;
import org.apache.directory.ldap.client.api.LdapNetworkConnection;

/**
 * Base class for all LDAP connections.
 * 
 * @author Brendan Douglas
 *
 */
public class BaseLdapConnection {
	protected String baseDN;
	protected String host;
	protected int port;
	protected boolean isSsl;
	protected String name;
	protected String credentials;
	
	protected LdapConnection connection;
	
	public BaseLdapConnection(String host, int port, boolean  isSsl, String name, String credentials, String baseDN) throws LdapException {		
		this.host = host;
		this.port = port;
		this.isSsl = isSsl;
		this.name = name;
		this.credentials = credentials;
		this.baseDN = baseDN;
	}

	
	protected void close() throws IOException {
		if (connection != null && !connection.isConnected()) {
			connection.close();
		}
	}

	
	protected void connect() throws LdapException {
		if (connection != null && connection.isConnected()) {
			return;
		}
		
		connection = new LdapNetworkConnection(host, port, isSsl);
		connection.bind(name, credentials);
		connection.setTimeOut(0);
	}
}

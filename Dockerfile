FROM fhirfactory/pegacorn-base-docker-apacheds:1.0.0

# Define ApacheDS version
ENV APACHEDS_VERSION=2.0.0-M24
ENV APACHEDS_SERVICE_NAME=apacheds-${APACHEDS_VERSION}-default

# Add schema
COPY ldap/schema/ms-user.ldif /tmp/
COPY ldap/schema/ms-userproxy.ldif /tmp/
COPY ldap/schema/partition-pegacorn-apacheds-mimic.ldif /tmp/
COPY ldap/schema/partition-pegacorn-apacheds-spok.ldif /tmp/

# TLS configuration
RUN mkdir -p /usr/local/apacheds
COPY run-apacheds.sh /usr/local/apacheds
RUN chmod -R 777 /usr/local/apacheds/run-apacheds.sh

ARG IMAGE_BUILD_TIMESTAMP
ENV IMAGE_BUILD_TIMESTAMP=${IMAGE_BUILD_TIMESTAMP}
RUN echo IMAGE_BUILD_TIMESTAMP=${IMAGE_BUILD_TIMESTAMP}

CMD ["/usr/local/apacheds/run-apacheds.sh"]


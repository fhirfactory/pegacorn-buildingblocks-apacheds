#
#   Licensed to the Apache Software Foundation (ASF) under one 
#   or more contributor license agreements.  See the NOTICE file
#   distributed with this work for additional information
#   regarding copyright ownership.  The ASF licenses this file
#   to you under the Apache License, Version 2.0 (the
#   "License"); you may not use this file except in compliance
#   with the License.  You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
#   Unless required by applicable law or agreed to in writing,
#   software distributed under the License is distributed on an
#   "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY 
#   KIND, either express or implied.  See the License for the 
#   specific language governing permissions and limitations
#   under the License.
#

FROM openjdk:11

# Install LDAP tools
ENV DEBIAN_FRONTEND=noninteractive
RUN \
    apt-get update && \
    apt-get install -y -qq ldap-utils netcat net-tools && \
    rm -rf /var/lib/apt/lists/*

# Define ApacheDS version
ENV APACHEDS_VERSION=2.0.0-M24
ENV APACHEDS_SERVICE_NAME=apacheds-${APACHEDS_VERSION}-default

# Install ApacheDS
RUN \
    wget http://archive.apache.org/dist/directory/apacheds/dist/${APACHEDS_VERSION}/apacheds-${APACHEDS_VERSION}-amd64.deb -q -O /tmp/apacheds.deb && \
    dpkg -i /tmp/apacheds.deb && \
    rm /tmp/apacheds.deb

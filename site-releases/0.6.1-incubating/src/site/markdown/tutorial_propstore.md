<!---
Licensed to the Apache Software Foundation (ASF) under one
or more contributor license agreements.  See the NOTICE file
distributed with this work for additional information
regarding copyright ownership.  The ASF licenses this file
to you under the Apache License, Version 2.0 (the
"License"); you may not use this file except in compliance
with the License.  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied.  See the License for the
specific language governing permissions and limitations
under the License.
-->

# Helix Tutorial: Application Property Store

In this chapter, we\'ll learn how to use the application property store.

### Property Store

It is common that an application needs support for distributed, shared data structures.  Helix uses Zookeeper to store the application data and hence provides notifications when the data changes.

While you could use Zookeeper directly, Helix supports caching the data and a write-through cache. This is far more efficient than reading from Zookeeper for every access.

See [HelixManager.getHelixPropertyStore](./apidocs/reference/org/apache/helix/store/package-summary.html) for details.
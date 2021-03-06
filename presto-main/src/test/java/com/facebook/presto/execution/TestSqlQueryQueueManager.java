/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.facebook.presto.execution;

import io.airlift.json.ObjectMapperProvider;
import org.testng.annotations.Test;
import org.weakref.jmx.MBeanExporter;

import java.lang.management.ManagementFactory;

public class TestSqlQueryQueueManager
{
    @Test
    public void testJsonParsing()
    {
        String path = this.getClass().getClassLoader().getResource("queue_config.json").getPath();
        QueryManagerConfig config = new QueryManagerConfig();
        config.setQueueConfigFile(path);
        new SqlQueryQueueManager(config, new ObjectMapperProvider().get(), new MBeanExporter(ManagementFactory.getPlatformMBeanServer()));
    }
}

/*
 * Copyright 2016 Petra Bierleutgeb
 *
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

package io.ontherocks.hellogrpc
package clock

import io.ontherocks.hellogrpc.server.HelloGrpcServer

import scala.concurrent.ExecutionContext

object ClockServerApp {

  def main(args: Array[String]): Unit = {
    val serverServiceDefinition = ClockGrpc.bindService(new ClockService, ExecutionContext.global)
    val server = new HelloGrpcServer(serverServiceDefinition)
    server.start()
    server.blockUntilShutdown()
  }

}

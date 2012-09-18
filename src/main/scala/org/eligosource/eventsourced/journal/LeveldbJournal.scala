/*
 * Copyright 2012 Eligotech BV.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.eligosource.eventsourced.journal

import java.io.File

import akka.actor._

object LeveldbJournal {
  def processorStructured(dir: File)(implicit system: ActorSystem): ActorRef =
    system.actorOf(Props(new LeveldbJournalPS(dir)))

  def sequenceStructured(dir: File)(implicit system: ActorSystem): ActorRef =
    system.actorOf(Props(new LeveldbJournalSS(dir)))

  def apply(dir: File)(implicit system: ActorSystem) =
    processorStructured(dir)
}

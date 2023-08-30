/*
 * Copyright 2012-2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package smoketest.pulsar.reactive;

import java.util.ArrayList;
import java.util.List;

import reactor.core.publisher.Mono;

import org.springframework.pulsar.reactive.config.annotation.ReactivePulsarListener;
import org.springframework.stereotype.Component;

@Component
class SampleMessageConsumer {

	private List<SampleMessage> consumed = new ArrayList<>();

	List<SampleMessage> getConsumed() {
		return this.consumed;
	}

	@ReactivePulsarListener(topics = SampleReactivePulsarApplication.TOPIC)
	Mono<Void> consumeMessagesFromPulsarTopic(SampleMessage msg) {
		System.out.println("**** CONSUME: " + msg);
		this.consumed.add(msg);
		return Mono.empty();
	}

}

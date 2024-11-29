/*
 * Copyright 2013-2024 the original author or authors.
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
package org.springframework.data.convert;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.time.*;
import java.util.*;

import static java.time.ZoneId.systemDefault;

/**
 * Helper class to register numeric boolean {@link Converter} implementations.
 *
 * @author HyeongSeok Ryu
 */
public abstract class NumericBooleanConverters {

	/**
	 * Returns the converters to be registered.
	 *
	 * @return the converters to be registered.
	 */
	public static Collection<Converter<?, ?>> getConvertersToRegister() {

		List<Converter<?, ?>> converters = new ArrayList<>();
		converters.add(ByteToBooleanConverter.INSTANCE);

		return converters;
	}

	@ReadingConverter
	public enum ByteToBooleanConverter implements Converter<Byte, Boolean> {

		INSTANCE;

		@Nullable
		@Override
		public Boolean convert(Byte source) {
			if (source == null) {
				return null;
			}
			if (1 == source) {
				return Boolean.TRUE;
			}
			return 0 == source ? Boolean.FALSE : null;
		}
	}

//	@WritingConverter
//	public enum LocalDateTimeToDateConverter implements Converter<LocalDateTime, Date> {
//
//		INSTANCE;
//
//		@NonNull
//		@Override
//		public Date convert(LocalDateTime source) {
//			return Date.from(source.atZone(systemDefault()).toInstant());
//		}
//	}

}

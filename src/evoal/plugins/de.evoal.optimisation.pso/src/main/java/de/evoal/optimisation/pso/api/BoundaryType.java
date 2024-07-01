/* %%
 *
 * This code is based on JPSO (https://github.com/jpr86/JPSO), an Apache 2.0
 *   licensed software by Jeff Ridder.
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
package de.evoal.optimisation.pso.api;

/**
 * Enumerates the types of boundaries.
 */
public enum BoundaryType {
    /**
     * Values will wrap through boundaries (as in periodic boundary conditions).
     */
    WRAP,
    /**
     * Values will bounce off of boundaries.
     */
    BOUNCE,
    /**
     * Values will stick to boundaries.
     */
    STICK

}

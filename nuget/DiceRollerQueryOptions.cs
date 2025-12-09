using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.DiceRoller
{
    /// <summary>
    /// Query options for the Dice Roller API
    /// </summary>
    public class DiceRollerQueryOptions
    {
        /// <summary>
        /// Dice notation in XdY format (e.g., 3d6, 2d20, default: 1d6)
        /// Example: 3d6
        /// </summary>
        [JsonProperty("dice")]
        public string Dice { get; set; }

        /// <summary>
        /// Modifier to add to the total (can be negative, default: 0)
        /// Example: 5
        /// </summary>
        [JsonProperty("modifier")]
        public string Modifier { get; set; }
    }
}

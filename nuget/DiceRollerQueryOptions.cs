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
        /// Dice notation in XdY format (e.g., 3d6, 2d20, default: 1d6); d20 means one die and an inline modifier like 3d6+5 is added to modifier
        /// </summary>
        [JsonProperty("dice")]
        public string Dice { get; set; }

        /// <summary>
        /// Modifier to add to the total (can be negative, -10000 to 10000)
        /// </summary>
        [JsonProperty("modifier")]
        public int? Modifier { get; set; }
    }
}

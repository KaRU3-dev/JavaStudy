using System.Net.Http.Json;
using System.Text.Json;
using Microsoft.AspNetCore.Mvc;

[Route("api/users")]
public class UserDataController : ControllerBase
{
    [HttpGet("{id}/save-data")]
    public IActionResult GetUserData(int id)
    {
        // Temporary implementation
        if (id == 1)
        {
            if (System.IO.File.Exists($"./data/{id}.json"))
            {
                var data = System.IO.File.ReadAllText($"./data/{id}.json");
                var userData = JsonSerializer.Deserialize<SaveDataModel>(data);
                return Ok(userData);
            }
            else
            {
                return NotFound();
            }
        }
        else
        {
            return NotFound();
        }
    }

    [HttpPost("{id}/save-data")]
    public IActionResult SaveUserData(int id, [FromBody] string data)
    {
        // Temporary implementation
        if (id == 1)
        {
            System.IO.File.WriteAllText($"./data/{id}.json", data);
            return Ok();
        }
        else
        {
            return NotFound();
        }
    }
}

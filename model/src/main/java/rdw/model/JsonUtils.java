package rdw.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;

/**
 *
 */
public class JsonUtils {

    public static ContentMetaData contentMetaDataFromJson(final InputStream is) {
        final Gson gson = new GsonBuilder()
                .registerTypeAdapter(Integer.class, new ScoreDeserializer())
                .create();
        try {
            return gson.fromJson(new InputStreamReader(is, "utf-8"), ContentMetaData.class);
            // TODO - do we need a cleanup step to remove empty claims, levels, etc.?
        } catch (UnsupportedEncodingException e) {
            // TODO - this will never happen
            return null;
        }
    }

    public static ContentMetaData contentMetaDataFromJson(final String json) {
        return new Gson().fromJson(new StringReader(json), ContentMetaData.class);
    }

    public static String contentMetaDataToJson(final ContentMetaData metaData) {
        final StringBuilder sb = new StringBuilder();
        new Gson().toJson(metaData, ContentMetaData.class, sb);
        return sb.toString();
    }

    /**
     * Deserialize values that are like scores. Deals with number vs. string, blank string, etc.
     */
    private static class ScoreDeserializer implements JsonDeserializer<Integer> {

        @Override
        public Integer deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            if (json.isJsonNull()) return null;
            if (json.isJsonPrimitive()) {
                final JsonPrimitive primitive = json.getAsJsonPrimitive();
                if (primitive.isString() && primitive.getAsString().isEmpty()) return null;
                return primitive.getAsInt();
            }
            throw new JsonParseException("Value cannot be interpreted as integer " + json.toString());
        }
    }
}
